# 该镜像需要依赖的基础镜像
FROM openjdk:11
# 指定维护者的名字
MAINTAINER wang
VOLUME /tmp
RUN echo "export LC_ALL=zh_CN.UTF-8"  >>  /etc/profile
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
# 将当前目录下的jar包复制到docker容器的/目录下
ADD ./target/appleyk-0.0.1-SNAPSHOT.war /docker-project/appleyk-0.0.1-SNAPSHOT.war
RUN bash -c 'touch /appleyk-0.0.1-SNAPSHOT.war'

expose 8099
# 指定docker容器启动时运行jar包
ENTRYPOINT ["java","-jar","/appleyk-0.0.1-SNAPSHOT.war"]