# ---- Build stage -----------------------------------------------------------
FROM eclipse-temurin:25-jdk AS build
WORKDIR /build

COPY .mvn .mvn
COPY mvnw pom.xml ./
COPY src src
RUN chmod +x mvnw \
 && ./mvnw -B -DskipTests package \
 && cp target/community-map-api-*.jar /build/app.jar

# ---- Runtime stage ---------------------------------------------------------
FROM eclipse-temurin:25-jre
WORKDIR /app

RUN useradd --system --no-create-home --shell /usr/sbin/nologin app
COPY --from=build /build/app.jar app.jar
USER app

# Tuned for a small instance (512 MB, shared CPU): cap the heap, use the
# low-overhead collector and skip the heavier JIT tier to start faster.
ENV JAVA_OPTS="-XX:MaxRAMPercentage=60 -XX:+UseSerialGC -XX:TieredStopAtLevel=1 -Xss512k"

EXPOSE 8080
ENTRYPOINT ["sh", "-c", "exec java $JAVA_OPTS -jar app.jar"]
