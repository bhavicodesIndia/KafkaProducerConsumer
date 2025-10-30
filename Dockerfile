FROM ubuntu:latest
LABEL authors="bhavsharma"

ENTRYPOINT ["top", "-b"]