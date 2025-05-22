# Sideload

medium

I thought complexity equals to better security, can you proof me wrong?

###### Author: Marc


## Solution

We're using `jadx` for this one.

```
$ ~/Software/jadx/build/jadx/bin/jadx app-debug.apk 
INFO  - loading ...
INFO  - processing ...
ERROR - finished with errors, count: 19              
```

Well that isn't good...

```
$ dust -b app-debug 
1.1M       ┌── values
6.0M     ┌─┴ res
9.5M     ├── classes.dex
 17M   ┌─┴ resources
1.7M   │     ┌── flow
4.3M   │   ┌─┴ coroutines
4.3M   │ ┌─┴ kotlinx
4.8M   │ │     ┌── material
4.8M   │ │   ┌─┴ android
4.9M   │ │ ┌─┴ google
4.9M   │ ├─┴ com
1.3M   │ │   ┌── ArraysKt___ArraysKt.java
3.2M   │ │ ┌─┴ collections
7.2M   │ ├─┴ kotlin
2.0M   │ │ ┌── appcompat
1.3M   │ │ │ ┌── core
2.9M   │ │ ├─┴ constraintlayout
3.0M   │ │ ├── core
 13M   │ ├─┴ androidx
 31M   ├─┴ sources
 48M ┌─┴ app-debug
```