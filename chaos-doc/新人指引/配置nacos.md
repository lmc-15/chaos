配置 Nacos 服务器
确保您已经安装并启动了 Nacos 服务器。如果还没有，可以按照以下步骤进行安装：
```bash
# 下载 Nacos
wget https://github.com/alibaba/nacos/releases/download/2.0.3/nacos-server-2.0.3.zip

# 解压 Nacos
unzip nacos-server-2.0.3.zip

# 进入 Nacos 目录并启动
cd nacos/bin
sh startup.sh -m standalone
```
默认情况下，Nacos 服务器会在 8848 端口启动。