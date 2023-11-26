cd "./api-gateway"
mvn clean install -Dmaven.test.skip=true
cd ".."

cd "./cart-service"
mvn clean install -Dmaven.test.skip=true
cd ".."

cd "./order-service"
mvn clean install -Dmaven.test.skip=true
cd ".."

cd "./eureka-server"
mvn clean install -Dmaven.test.skip=true
cd ".."

cd "./product-service"
mvn clean install -Dmaven.test.skip=true
cd ".."

cd "./user-service"
mvn clean install -Dmaven.test.skip=true
cd ".."