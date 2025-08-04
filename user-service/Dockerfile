FROM tomcat:9.0-jdk17
# デプロイしたい対象→デプロイ先
COPY target/user-service.war /usr/local/tomcat/webapps/
# （必要に応じて）環境変数や時刻設定など
#例 ENV TZ=Asia/Tokyo

# ポート開放（Tomcatのデフォルトポート）実行ではなく宣言
EXPOSE 8080

# 学習環境、本番環境の切り替え
# COPY docker/setenv.sh /usr/local/tomcat/bin/setenv.sh
# RUN chmod +x /usr/local/tomcat/bin/setenv.sh

# Json形式で動かすプログラムと命令を記述
# 今回はtomcatの公式スクリプトcatalina.sh
ENTRYPOINT ["catalina.sh"]
CMD ["run"]