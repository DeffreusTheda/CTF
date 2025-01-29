#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include <jni.h>

#define MAX_LINES 527
#define MAX_LINE_LENGTH 85

JavaVM *jvm;
JNIEnv *env;
JavaVMInitArgs vm_args;
JavaVMOption options[1];

int init_jvm() {
  // Set the classpath to current directory
  options[0].optionString = "-Djava.class.path=.";
  
  vm_args.version = JNI_VERSION_1_8;
  vm_args.nOptions = 1;
  vm_args.options = options;
  vm_args.ignoreUnrecognized = 0;
  
  // Create the JVM
  jint result = JNI_CreateJavaVM(&jvm, (void**)&env, &vm_args);
  if (result != JNI_OK) {
    fprintf(stderr, "Failed to create JVM (%d)\n", result);
    return 1;
  }
  
  printf("JVM created successfully\n");
  
  // Find the Java class
  jclass helloClass = (*env)->FindClass(env, "Main");
  if (helloClass == NULL) {
    fprintf(stderr, "Failed to find HelloWorld class\n");
    (*jvm)->DestroyJavaVM(jvm);
    return 1;
  }
  
  // Call static method sayHello()
  jmethodID sayHelloMethod = (*env)->GetStaticMethodID(env, helloClass, "pBanner", "()V");
  if (sayHelloMethod == NULL) {
    fprintf(stderr, "Failed to find sayHello method\n");
    (*jvm)->DestroyJavaVM(jvm);
    return 1;
  }
  
  (*env)->CallStaticVoidMethod(env, helloClass, sayHelloMethod);
  
  // Call instance method add(int, int)
  // First, get the constructor
  jmethodID constructor = (*env)->GetMethodID(env, helloClass, "<init>", "()V");
  if (constructor == NULL) {
    fprintf(stderr, "Failed to find constructor\n");
    (*jvm)->DestroyJavaVM(jvm);
    return 1;
  }
  
  // Create an instance
  jobject helloObj = (*env)->NewObject(env, helloClass, constructor);
  if (helloObj == NULL) {
    fprintf(stderr, "Failed to create object\n");
    (*jvm)->DestroyJavaVM(jvm);
    return 1;
  }
  
  // Get the add method
  jmethodID addMethod = (*env)->GetMethodID(env, helloClass, "add", "(II)I");
  if (addMethod == NULL) {
    fprintf(stderr, "Failed to find add method\n");
    (*jvm)->DestroyJavaVM(jvm);
    return 1;
  }
  
  // Call the add method
  jint sum = (*env)->CallIntMethod(env, helloObj, addMethod, 5, 7);
  printf("Result of add(5, 7) = %d\n", sum);
  
  // Check for exceptions
  if ((*env)->ExceptionCheck(env)) {
    (*env)->ExceptionDescribe(env);
    (*env)->ExceptionClear(env);
  }
  
  // Destroy the JVM
  (*jvm)->DestroyJavaVM(jvm);
  
  return 0;
}

void printbanner() {
  FILE *file = fopen("banners.txt", "r");
  if (!file) {
    perror("Failed to open banners.txt");
    return;
  }

  // Allocate on heap instead of stack
  char (*lines)[MAX_LINE_LENGTH] = malloc(MAX_LINES * sizeof(*lines));
  if (!lines) {
    perror("Failed to allocate memory");
    fclose(file);
    return;
  }
  
  int line_count = 0;
  int banner_starts[100];
  int banner_count = 0;
  
  banner_starts[banner_count++] = 0;
  
  while (fgets(lines[line_count], MAX_LINE_LENGTH, file) && line_count < MAX_LINES) {
    if (lines[line_count][0] == ',' && 
      (lines[line_count][1] == '\n' || lines[line_count][1] == '\r')) {
      banner_starts[banner_count++] = line_count + 1;
    }
    line_count++;
  }
  fclose(file);

  srand(time(NULL));
  
  int banner_idx = rand() % (banner_count - 1);
  int start = banner_starts[banner_idx];
  int end = (banner_idx + 1 < banner_count) ? banner_starts[banner_idx + 1] - 1 : line_count;

  // printf("Selected banner #%d:\n\n", banner_idx + 1);
  for (int i = start; i < end; i++) {
    if (lines[i][0] == ',' && 
      (lines[i][1] == '\n' || lines[i][1] == '\r')) {
      continue;
    }
    printf("%s", lines[i]);
  }
  printf("\n");
  
  free(lines);  // Don't forget to free
}

int main() {
  printbanner();
  init_jvm();
  /*
  this is the mother
  */
  return 0;
}
