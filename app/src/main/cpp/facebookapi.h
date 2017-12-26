//
// Created by DuongTung on 12/13/16.
//

#ifndef BYTE
typedef const char BYTE;
typedef char* LPBYTE;
#endif

#ifndef BOOL
typedef short BOOL;
#define TRUE 1
#define FALSE 0
#endif
#include <curl/curl.h>
#include <string>
#ifdef ANDROID
#include <android/log.h>
#include <jni.h>
#ifdef __LP64__
#define SIZE_T_TYPE "%lu"
#else
#define SIZE_T_TYPE "%u"
#endif
#endif

#ifdef ANDROID
#define LOGI(...) ((void)__android_log_print(ANDROID_LOG_INFO, "TestLibrary", __VA_ARGS__))
#else
#define LOGI(...) printf(__VA_ARGS__)
#endif

typedef struct _CURL_DOWNLOAD_OBJECT {
    long size;
    LPBYTE data;
} CURL_DOWNLOAD_OBJECT, *LPCURL_DOWNLOAD_OBJECT;

BOOL downloadUrl(const char* url, LPCURL_DOWNLOAD_OBJECT downloadObject);
size_t curlCallback(char *data, size_t size, size_t count, void* userdata);





