#!/bin/bash
# 工程初始化
# 在实际项目开发时都有自己的工程名、包名,该脚本帮助你快速将该demo工程修改成你想要的名称

author=man003@163.com
version=V1.0-20181213


usage(){
cat <<EOM
Desc: 初始化工程
Usage: $SHELL_NAME [options]
    -h |    print help usage

# ===============脚本使用方式====================
1.  将工程目录名修改成新工程名 
    如原工程名是 springmvc-demo 新工程名是 rocketmq-spring-demo 则将目录名改成rocketmq-spring-demo
2.  在initproject.config 中配置新工程的信息
3.  添加可执行权限
    chmod +x initproject.sh
4.  执行脚本
    ./initproject.sh
# ===============================================


EOM
exit 0
}


# 脚本所在目录路径
SHELL_DIR_PATH=$(cd $(dirname "$0");pwd)

# 脚本名称
SHELL_NAME=`basename $0`
# 脚本不包括后缀的文件名 如xx.sh 则文件名为 xx
SHELL_NAME0=${SHELL_NAME%.*}

# 基准路径
BASE_PATH=`dirname $SHELL_DIR_PATH`;
cd $BASE_PATH

# 设置环境变量
PATH=$PATH:$SHELL_DIR_PATH/util/;

# 依赖的shell 一行一个 如果没有x 权限 自动设置
RELIANT_SH="
	$SHELL_DIR_PATH/util/deleteEmptyDir.sh
"

for rs in $RELIANT_SH
do
	# 如果没有可执行权限 把权限加上
	if [ ! -x $rs ]; then
		chmod +x $rs
	fi
done



###############定义原工程相关变量###################

# 原工程名称
project_name_old=springmvc-demo

# 原工程中maven的 groupId
group_id_old=mang.demo

# 原工程中包名前缀
package_old=mang.demo.springmvc

# 原工程中开发代码的路径前缀
java_path_prefix_develop=src/main/java
# 原工程中测试代码的路径前缀
java_path_prefix_test=src/test/java


# 通过包名获取java文件实际路径
# 如包名为 mang.demo.springmvc 则其java路径在 src/main/java/mang/demo/springmvc
package_file_path_old=`echo "$package_old" | sed 's#\.#/#g'`
java_path_develop_old=${java_path_prefix_develop}/$package_file_path_old
java_path_test_old=${java_path_prefix_test}/$package_file_path_old

# 需要处理的工程
projects="common server web"

# 定义新工程相关变量默认值
# 注这些变量可通过 initproject.config 文件覆盖默认值

# 新工程的名称
project_name_new=mtest

# 新工程 maven中的groupID 用于替换pom.xml
group_id_new=com.mtest

# 新工程包名 
package_new=com.mtest





# 处理开发代码java路径
# 将java文件移动到新路径并删除原路径
process_java_file_path_develop() {
    local project=$1
    local move_from=${BASE_PATH}/${project_name_new}-$project/${java_path_develop_old}
    local move_to=${BASE_PATH}/${project_name_new}-$project/${java_path_develop_new}

    if [ -d $move_from ]
    then
        if [ ! -d ${move_to}  ]
        then
            mkdir -p ${move_to}
        fi
        mv $move_from/* $move_to
    fi
}

# 处理测试代码java路径
# 将java文件移动到新路径并删除原路径
process_java_file_path_test() {
    local project=$1
    local move_from=${BASE_PATH}/${project_name_new}-$project/${java_path_test_old}
    local move_to=${BASE_PATH}/${project_name_new}-$project/${java_path_test_new}

    if [ -d $move_from ]
    then
        if [ ! -d ${move_to}  ]
        then
            mkdir -p ${move_to}
        fi
        mv $move_from/* $move_to
    fi
}

###  ------------------------------- ###
###  Main script                     ###
###  ------------------------------- ###

while getopts h opt
do
  case "$opt" in
     h) usage
         ;;
     *) echo unexpect option $opt
         usage
		;;
  esac
done


# 获取配置文件覆盖变量默认值
initconfig=${SHELL_DIR_PATH}/${SHELL_NAME0}.config
if [ -f $initconfig ]
then
    echo 采用$(basename ${initconfig})覆盖默认配置
    . $initconfig

    # 通过新工程的包名取出java文件路径
    # 如下将 .变成/  如 com.mtest 将变成 com/mtest
    package_file_path_new=`echo "$package_new" | sed 's#\.#/#g'`
    java_path_develop_new=${java_path_prefix_develop}/${package_file_path_new}
    java_path_test_new=${java_path_prefix_test}/${package_file_path_new}
fi

echo 新工程名  $project_name_new 
echo 新groupID $group_id_new
echo 新包名    $package_new
echo

echo 正在处理 .git目录 有则删除
git_path=$BASE_PATH/.git
if [ -d ${git_path} ]
then
    rm -rf $git_path
fi

echo 正在处理 .svn目录 有则删除
svn_path=$BASE_PATH/.svn
if [ -d ${svn_path} ]
then
    rm -rf $svn_path
fi

echo "正在处理 idea相关文件 (删除.idea  *.iml)"
idea_path=$BASE_PATH/.idea
if [ -d ${idea_path} ]
then
    rm -rf $idea_path
fi
find . -name "*.iml"|xargs rm -rf


# org.eclipse.wst.common.component
echo 正在处理  eclipse相关文件
#echo 正在处理 org.eclipse.wst.common.component
find . -name "org.eclipse.wst.common.component" |xargs sed -ig "s/$project_name_old/$project_name_new/g"
find . -name "org.eclipse.wst.common.componentg" |xargs -n5 rm -rf

#echo 正在处理 .project
find . -name "*.project" |xargs sed -ig "s/$project_name_old/$project_name_new/g"
find . -name "*.projectg" |xargs -n5 rm -rf

echo 正在处理 工程目录名
for proj in $projects
do
    mv $BASE_PATH/${project_name_old}-${proj} $BASE_PATH/${project_name_new}-${proj}
    #mv $BASE_PATH/springmvc-demo-server $BASE_PATH/$project_name_new-server
done


echo 正在处理 java文件存储路径
for proj in $projects
do
    #echo 正在处理develop $proj
   process_java_file_path_develop $proj

    #echo 正在处理test $proj
    process_java_file_path_test $proj
done

echo 正在处理 java文件包路径
find . -name "*.java" |xargs sed -ig "s/$package_old/$package_new/g"
find . -name "*.javag" |xargs -n5 rm -rf

echo 正在处理 controller中的链接注释
find . -name "*Controller.java" |xargs sed -ig "s/$project_name_old/$project_name_new/g"
find . -name "*Controller.javag" |xargs -n5 rm -rf


echo 正在处理 pom.xml
# 注 对于包名中有. 而在正在表达式中 .正好又是特殊字符代表匹配所有字符,这里没有转义,有可能有问题 但既然.可匹配所有字符,当然可以匹配自己了,所以应该没有问题
# 另我先替换groupId 最后替换project名称(artifactId) 也有用意 我怕groupId中包含project名先替换了导致错误
find . -name "pom.xml" |xargs sed -ig "s/$group_id_old/$group_id_new/g"
find . -name "pom.xml" |xargs sed -ig "s/$project_name_old/$project_name_new/g"
find . -name "pom.xmlg" |xargs -n5 rm -rf

echo 正在处理 xml文件
# 因spring的配置文件名老变 所以这里想写活 如下试验了用如下的方式也好用
#find . -name "applicationContext-local.xml" |xargs sed -ig "s/$package_old/$package_new/g"
#find . -name "*applicationContext-local.xmlg" |xargs  -n5 rm -rf
find . -name "applicationContext-*.xml" |xargs sed -ig "s/$package_old/$package_new/g"
find . -name "mvc-dispatcher-servlet.xml" |xargs sed -ig "s/$package_old/$package_new/g"
find . -name "*applicationContext-*.xmlg" |xargs  -n5 rm -rf
find . -name "*mvc-dispatcher-servlet.xmlg" |xargs  -n5 rm -rf


echo 正在处理 删除空目录
deleteEmptyDir.sh $BASE_PATH >/dev/null 2>&1


echo
echo done.


echo
echo
echo
echo ===============notice======================
echo 请手动将工程目录修改为 $project_name_new
echo 修改README.md
echo 然后将工程导入idea或eclipse
echo ===========================================


