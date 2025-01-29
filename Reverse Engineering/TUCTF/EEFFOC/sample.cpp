#include <stdexcept>
#include <windows.h>
#include <tchar.h>
#include <strsafe.h>
#include <include/jni.h>
 
#include <string>
#include <stdlib.h>
#include <vector>
#include <iostream>
 
 
class JVMLauncherException : public std::runtime_error {
public:
    JVMLauncherException(const std::string& message) : std::runtime_error(message) 
    { 
    };
};
 
class JVMLauncher {
public:
    JVMLauncher();
    void addJars(std::string inJar);
    void LaunchJVM();
    void StartJVMServer();
    void AddServerArguments(std::string);
private:
    typedef jint (JNICALL *CreateJavaVM)(JavaVM **pvm, void **penv, void *args);
 
    HINSTANCE     m_hDllInstance;
 
    std::string   m_JavaHome;
    std::string   m_ProductLibDir;
    std::string   m_JvmDllLocation;
 
    CreateJavaVM  m_JVMInstance;
    jclass        m_CacheServerLauncherClass;
    jmethodID     m_MainMethodID;
    JNIEnv       *m_JVMEnv;
    JavaVM       *m_RunningJVMInstance;    
 
    std::vector<std::string> m_listOfJars;
    std::vector<std::string> m_ServerArguments;
 
    void CheckForJNIException();
protected:
};
 
JVMLauncher::JVMLauncher() {
    // Check for JAVA_HOME
    char *pValue;
    size_t len;
    errno_t err = _dupenv_s( &pValue, &len, "JAVA_HOME" );
    if ( err ) {
        throw JVMLauncherException("JAVA_HOME not defined");
    }    
    m_JavaHome       = pValue;
    m_JvmDllLocation = m_JavaHome + "\\jre\\bin\\server\\jvm.dll";
 
    err = _dupenv_s( &pValue, &len, "PRODUCT HOME PATH" );
    if ( err ) {
        throw JVMLauncherException("PRODUCT HOME PATH not defined");
    }
    m_ProductLibDir = pValue;
 
    m_listOfJars.push_back("depedent1.jar");
    m_listOfJars.push_back("depedent2.jar");
    m_listOfJars.push_back("depedent3.jar");
    m_listOfJars.push_back("depedent4.jar");
    m_listOfJars.push_back("depedent5.jar");    
}
void JVMLauncher::AddServerArguments(std::string inParam) {
    m_ServerArguments.push_back(inParam);
}
void JVMLauncher::LaunchJVM() {
    // Construct the product specific class path.
    std::string strJavaClassPath = "-Djava.class.path=";
    for ( std::size_t idx = 0; idx < m_listOfJars.size() - 1 ; idx++) {
        strJavaClassPath += m_ProductLibDir + "\\lib\\" + m_listOfJars[idx] + ";";
    }
    strJavaClassPath += m_ProductLibDir + "\\lib\\" + m_listOfJars[m_listOfJars.size() - 1] ;
 
    // consruct java.library.path
    std::string strJavaLibraryPath =  "-Djava.library.path=";
    strJavaLibraryPath             += m_JavaHome + "\\lib" + "," + m_JavaHome + "\\jre\\lib";
 
     
    // try loading jvm dll
    m_hDllInstance = LoadLibraryA(m_JvmDllLocation.c_str());
    if( m_hDllInstance == 0) {
        throw JVMLauncherException("Cannot load jvm.dll");
    }
    m_JVMInstance = (CreateJavaVM)GetProcAddress(m_hDllInstance, "JNI_CreateJavaVM");
    if ( m_JVMInstance == NULL )  {
        throw JVMLauncherException("Cannot load jvm.dll");
    }
 
    JavaVMOption options[3];
    options[0].optionString  = const_cast<char*>(strJavaClassPath.c_str());
    options[1].optionString  = const_cast<char*>(strJavaLibraryPath.c_str());
    options[2].optionString  = "-verbose:jni";
 
    JavaVMInitArgs vm_args;
    vm_args.version            = JNI_VERSION_1_6; //JNI Version 1.4 and above
    vm_args.options            = options;    
    vm_args.nOptions           = 3;       
    vm_args.ignoreUnrecognized = JNI_TRUE;
 
    //Create the JVM
     
    jint res = m_JVMInstance(&m_RunningJVMInstance, (void **)&m_JVMEnv, &vm_args);
    if (res < 0)  {
        throw JVMLauncherException("Could not launch the JVM");
    }
 
    m_CacheServerLauncherClass = m_JVMEnv->FindClass("<your main class>");    
    CheckForJNIException();
 
    m_MainMethodID = m_JVMEnv->GetStaticMethodID(m_CacheServerLauncherClass, "main", "([Ljava/lang/String;)V");
    CheckForJNIException();
}
 
void JVMLauncher::StartJVMServer() {
 
    if ( m_RunningJVMInstance->AttachCurrentThread((LPVOID *)&m_JVMEnv, NULL) ) {
        std::cout << "Fail to attach the current thread " << std::endl;
    }
 
    jclass StringClass = m_JVMEnv->FindClass("java/lang/String");
    int numOfArguments = (int)m_ServerArguments.size() + 4 ;
    int argumentIndex = 0;
 
    jobjectArray jargs = m_JVMEnv->NewObjectArray(numOfArguments, StringClass, NULL);    
 
    m_JVMEnv->SetObjectArrayElement(jargs, argumentIndex++, m_JVMEnv->NewStringUTF("start"));
 
    std::string strJavaClassPath = "-classpath=";
    strJavaClassPath             += "\"";
    for ( std::size_t idx = 0; idx < m_listOfJars.size() - 1 ; idx++) {
        strJavaClassPath += m_ProductLibDir + "\\lib\\" + m_listOfJars[idx] + ";";
    }
    strJavaClassPath      += m_ProductLibDir + "\\lib\\" + m_listOfJars[m_listOfJars.size() - 1] ;
    strJavaClassPath      += "\"";
 
    m_JVMEnv->SetObjectArrayElement(jargs, argumentIndex++, m_JVMEnv->NewStringUTF(strJavaClassPath.c_str()));
 
    for ( std::vector<std::string>::iterator iter = m_ServerArguments.begin(); iter != m_ServerArguments.end(); ++iter) {
        std::string argument = *iter;
        m_JVMEnv->SetObjectArrayElement(jargs, argumentIndex++, m_JVMEnv->NewStringUTF(argument.c_str()));
    }
    m_JVMEnv->SetObjectArrayElement(jargs, argumentIndex++, m_JVMEnv->NewStringUTF("argument1"));    
    m_JVMEnv->SetObjectArrayElement(jargs, argumentIndex, m_JVMEnv->NewStringUTF("argument2"));    
 
    m_JVMEnv->CallStaticVoidMethod(m_CacheServerLauncherClass, m_MainMethodID, jargs);
 
    m_RunningJVMInstance->DestroyJavaVM();
 
    CheckForJNIException();
}
 
void JVMLauncher::CheckForJNIException() {
    jthrowable expt = m_JVMEnv->ExceptionOccurred();
    if (expt != NULL) {
        m_JVMEnv->ExceptionClear();
        jmethodID toString = m_JVMEnv->GetMethodID(m_JVMEnv->FindClass("java/lang/Object"), "toString", "()Ljava/lang/String;");
        jstring estring = (jstring) m_JVMEnv->CallObjectMethod(expt, toString);
        jboolean isCopy;
        std::string message = m_JVMEnv->GetStringUTFChars(estring, &isCopy);
        throw JVMLauncherException(message);
    }
}
