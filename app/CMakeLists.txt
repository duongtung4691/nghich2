cmake_minimum_required(VERSION 3.4.1)
project(MapGo)
# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds it for you.
# Gradle automatically packages shared libraries with your APK.
include(AndroidNdkGdb)
include(AndroidNdkModules)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")
add_library( native-lib
             SHARED
             src/main/cpp/native-lib.cpp
             src/main/cpp/facebookapi.cpp
             src/main/cpp/curlHtpp.cpp
             src/main/cpp/curlHtpp.h
             src/main/cpp/facebookapi.h)
add_library( curl
             SHARED
             IMPORTED )
add_dependencies(curl libcurl)
set_target_properties( # Specifies the target library.
                       curl

                       # Specifies the parameter you want to define.
                      PROPERTIES IMPORTED_LOCATION

                       # Provides the path to the library you want to import.
                      /Users/MacBookPro/Projects/DTung/android_event/app/src/main/libs/${ANDROID_ABI}/libcurl.a )

add_library( crypto
              SHARED
              IMPORTED )
add_dependencies(crypto libcrypto)
set_target_properties( # Specifies the target library.
                       crypto

                      PROPERTIES IMPORTED_LOCATION

                       /Users/MacBookPro/Projects/DTung/android_event/app/src/main/libs/${ANDROID_ABI}/libcrypto.a )
add_library( ssl
              SHARED
              IMPORTED )
add_dependencies(ssl openssl)

set_target_properties( # Specifies the target library.
                      ssl

                      PROPERTIES IMPORTED_LOCATION

                       /Users/MacBookPro/Projects/DTung/android_event/app/src/main/libs/${ANDROID_ABI}/libssl.a )
include_directories(src/main/cpp/include)
find_library( log-lib
              log )
find_package(ZLIB REQUIRED)
include_directories(${ZLIB_INCLUDE_DIRS})
target_link_libraries( native-lib
                        ssl
                        crypto
                        curl
                       ${log-lib}
                       ${ZLIB_LIBRARIES})
