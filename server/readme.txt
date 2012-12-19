# CentOS 7.6 x86-x64

rpm -ivh socat-1.7.3.2-2.el7.x86_64.rpm
rpm -ivh erlang-22.1.8-1.el7.x86_64.rpm
rpm -ivh rabbitmq-server-3.7.22-1.el7.noarch.rpm

rabbitmq-server start
rabbitmq-server -detached

rabbitmqctl status
rabbitmqctl stop

chkconfig rabbitmq-server on
systemctl enable rabbitmq-server                # 监听服务端口: 5672

systemctl stop rabbitmq-server
systemctl start rabbitmq-server
systemctl status rabbitmq-server

rabbitmq-plugins enable rabbitmq_management     # 监听管理端口: 15672
systemctl restart rabbitmq-server

rabbitmqctl delete_user lijk
rabbitmqctl add_user lijk 11111111
rabbitmqctl set_user_tags lijk administrator
rabbitmqctl list_users

rabbitmqctl set_permissions -p / lijk ".*" ".*" ".*"
rabbitmqctl list_permissions

http://localhost:15672/
guest/guest
lijk/11111111

-   4369 (epmd), 25672 (Erlang distribution)
-   5672, 5671 (AMQP 0-9-1 without and with TLS)
-   15672 (if management plugin is enabled)
-   61613, 61614 (if STOMP is enabled)
-   1883, 8883 (if MQTT is enabled)

# 日志
/var/log/rabbitmq
