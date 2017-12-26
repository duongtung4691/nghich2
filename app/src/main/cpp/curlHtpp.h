//
// Created by DuongTung on 12/14/16.
//

#ifndef MAPGO_CURLHTPP_HPP
#define MAPGO_CURLHTPP_HPP

#include <stdlib.h>
#include <vector>
#include <map>
#include <string>
#include <jni.h>
#include <curl/curl.h>
#include <android/log.h>

#undef DEBUG
#define DEBUG

#ifdef DEBUG

#define LOG_TAG    "Bytelee_JNI"
#undef  LOG
#define LOGD(...)  __android_log_print(ANDROID_LOG_DEBUG,LOG_TAG,__VA_ARGS__)
#define LOGI(...)  __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)
#define LOGW(...)  __android_log_print(ANDROID_LOG_WARN,LOG_TAG,__VA_ARGS__)
#define LOGE(...)  __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS__)
#define LOGF(...)  __android_log_print(ANDROID_LOG_FATAL,LOG_TAG,__VA_ARGS__)

#else
#undef LOG
#define LOGD(...)
#define LOGI(...)
#define LOGW(...)
#define LOGE(...)
#define LOGF(...)

#endif
//using namespace std;
//
//class curlHttp {
//public :
//    string jstring2str(JNIEnv* env, jstring jstr);
//    void write_data(void *ptr, size_t size, size_t nmemb, void *stream);
//    map<string, string>processWithRequestInfo(JNIEnv* env, jobjectArray keys, jobjectArray values);
//    string mergeParams(map<string, string>params);
//    bool configureCURL(CURL *handle);
//    int processPostTask(const char* url, const char* payload, size_t payload_size, void* stream);
//    int  processGetTask(const char *url, void *stream);
//    string getURL(const char* url);
//    string postURL(const char* url, map<string, string>params);
//};
std::string BASE_URL = "http://mapgo.tk/api/";
std::string  LOGIN="login";
std::string  EVENTS="events";
std::string  CATEGORIES="categories";
std::string  token;

#ifdef __cplusplus
extern "C" {
#endif
/**
 * Class:     com_ningso_curljnihttp_CurlHttpUtils
 * Method:    getUrl
 * Signature: (Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
 *
 **/
JNIEXPORT jstring JNICALL Java_com_map_event_model_CurlMode_login
        (JNIEnv *, jclass, jobjectArray, jobjectArray);

JNIEXPORT jstring JNICALL Java_com_map_event_model_CurlMode_connectFacebook
        (JNIEnv *, jobject);

/**
 * Class:     com_ningso_curljnihttp_CurlHttpUtils
 * Method:    postUrl
 * Signature: (Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
 **/

JNIEXPORT jstring JNICALL Java_com_map_event_model_CurlMode_postUrl
        (JNIEnv *, jclass, jstring, jobjectArray, jobjectArray);

JNIEXPORT jstring JNICALL Java_com_map_event_model_CurlMode_getEvent
        (JNIEnv *, jclass, jobjectArray, jobjectArray);

JNIEXPORT void JNICALL Java_com_map_event_model_CurlMode_setToken
        (JNIEnv *env, jclass clz,jstring token);
JNIEXPORT jstring JNICALL Java_com_map_event_model_CurlMode_getCategories
        (JNIEnv *env, jclass clz);
#ifdef __cplusplus
}
#endif
#endif //MAPGO_CURLHTPP_HPP
