#include <jni.h>
#include <string>
#include <iostream>
using namespace std;

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_androidCpp_MainActivity_stringFromJNI(JNIEnv* env, jobject) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jint JNICALL
Java_com_example_androidCpp_MainActivity_test(JNIEnv *env, jobject) {
    return 0;
}