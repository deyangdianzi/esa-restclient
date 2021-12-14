---
sort: 7
---

# 文件上传及下载

`RestClient`支持文件上传和下载功能。**需要说明地是，对于内容较小的文件，可通过直接将文件内容写入请求body中或者直接从响应body中读取。** 本文只讨论当文件内容过大，直接读取或者写入有OOM风险时的大文件上传和下载功能。

{% include list.liquid all=true %}