#!/bin/bash
version=1.0.0
imagename=appleyk-demo
container=appleyk-demo
echo "远程机器执行docker ps"
docker ps
if [[ "$(docker inspect $container 2> /dev/null | grep $container)" != "" ]];
then
  echo $container "容器存在，停止并删除"
  echo "docker stop" $container
  docker stop $container
  echo "docker rm" $container
  docker rm $container
else
  echo $container "容器不存在"
fi
# 删除镜像
echo "远程机器执行docker images"
docker images
if [[ "$(docker images -q $imagesname 2> /dev/null)" != "" ]];
then
  echo $imagesname '镜像存在，删除它'
  docker rmi $(docker images -q $imagesname 2> /dev/null)
else
  echo $imagesname '不存在'
fi
docker pull registry.cn-hangzhou.aliyuncs.com/ali-wang/docker-project:$version
docker run -d --name appleyk-demo -p 8099:8099 registry.cn-hangzhou.aliyuncs.com/ali-wang/docker-project:$version