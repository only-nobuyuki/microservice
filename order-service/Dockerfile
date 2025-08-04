FROM openjdk:17-jdk
# デプロイしたい対象→デプロイ先
COPY target/order-service.jar order-service.jar
# （必要に応じて）環境変数や時刻設定など
#例 ENV TZ=Asia/Tokyo

# ポート開放（Tomcatのデフォルトポート）実行ではなく宣言
EXPOSE 8080

# Json形式で動かすプログラムと命令を記述
# 今回はtomcatの公式スクリプトcatalina.sh
ENTRYPOINT ["java", "-jar", "order-service.jar"]
CMD ["--spring.profiles.active=dev"]