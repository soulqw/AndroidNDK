#include <jni.h>
#include <string>
#include <android/log.h>

#include <iostream>


extern "C" JNIEXPORT jstring JNICALL
Java_com_qw_androidndksample_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT void JNICALL
Java_com_qw_androidndksample_MainActivity_test1(JNIEnv *env,
                                                jobject /* this */,
                                                jint intValue) {
    // accept boolean from java
    int age = intValue;
    __android_log_print(1, "TEST", "int:%d", age);

}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_qw_androidndksample_MainActivity_javaToNativeString(JNIEnv *env, jobject thiz, jint a,
                                                             jstring b) {
    char *second = (char*) (env->GetStringUTFChars(b, JNI_FALSE));
    return env->NewStringUTF(second);
}
