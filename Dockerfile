FROM ibmcom/websphere-liberty:full-java17-openj9-ubi as staging

COPY --chown=1001:0 target/libertyapp.jar \
                    /staging/fat-libertyapp.jar

RUN springBootUtility thin \
 --sourceAppPath=/staging/fat-libertyapp.jar \
 --targetThinAppPath=/staging/thin-libertyapp.jar \
 --targetLibCachePath=/staging/lib.index.cache

FROM ibmcom/websphere-liberty:full-java17-openj9-ubi

ARG VERSION=1.0
ARG REVISION=SNAPSHOT


COPY --chown=1001:0 src/main/liberty/config/server.xml /config/

COPY --chown=1001:0 --from=staging /staging/lib.index.cache /lib.index.cache

COPY --chown=1001:0 --from=staging /staging/thin-libertyapp.jar \
                    /config/dropins/spring/thin-libertyapp.jar

RUN configure.sh