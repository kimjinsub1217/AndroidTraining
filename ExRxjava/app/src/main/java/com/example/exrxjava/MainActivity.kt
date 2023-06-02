package com.example.exrxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.constraintlayout.motion.widget.Debug.getLocation
import androidx.constraintlayout.motion.widget.Debug.getLocation2
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable


class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        // 정적인 값을 방출하는 Observable을 생성
//        // just : 인자로 넣은 데이터를 차례로 발행하려고 Observable을 생성한다.
//        val observable = Observable.just(1,2,3,4,5)
//        val observer = object : Observer<Int> {
//
//            //  Observer가 구독(subscribe)을 시작할 때 호출됩니다
//            override fun onSubscribe(d: Disposable) {
//                Log.d(TAG,"onSubscribe")
//            }
//
//            // 에러가 발생했을 때 호출
//            override fun onError(e: Throwable) {
//                Log.d(TAG,"onError ${e.toString()}")
//            }
//            // Observer가 모든 데이터를 성공적으로 처리하고 완료되었을 때 호출
//            override fun onComplete() {
//                Log.d(TAG,"onComplete")
//            }
//            //  Observable로부터 데이터를 수신할 때 호출됩니다.
//            override fun onNext(t: Int) {
//                Log.d(TAG,"onNext : $t")
//            }
//
//        }
//        // Observer를 Observable에 구독한다. 이를 통해 Observable은 데이터를 발행하고
//        // Observer는 해당 데이터를 처리하게 됩니다.
//        observable.subscribe(observer)
//
//        intervalOperator().subscribe(
//            {
//                Log.d("intervalOperator","onNext : $it")
//                getLocation()
//            },
//            {
//                Log.d("intervalOperator","onError ${it}")
//            },
//            {
//                Log.d("intervalOperator","onComplete")
//            }
//        ).let { _ -> }

//        timerOperator().subscribe(
//            {
//                Log.d("timerOperator","onNext : $it")
//                getLocation()
//            },
//            {
//                Log.d("timerOperator","onError ${it}")
//            },
//            {
//                Log.d("timerOperator","onComplete")
//            }
//        ).let { _ -> }

//        createOperator().subscribe(
//            {
//                Log.d("createOperator", "onNext : $it")
//
//            },
//            {
//                Log.d("createOperator", "onError ${it}")
//            },
//            {
//                Log.d("createOperator", "발행완료")
//            }
//        ).let { _ -> }

//        filter().filter {
//            it.age == 20
//        }
//            .subscribe(
//                {
//                    Log.d("filter", "onNext : $it")
//
//                },
//                {
//                    Log.d("filter", "onError ${it}")
//                },
//                {
//                    Log.d("filter", "20살인 뉴진스 멤버")
//                }
//            ).let { _ -> }
//
//    last()
//        .last( NewJeans(1,"민지",20)) // 기본값을 주는 방법
////        .lastElement() // 기본값을 주지 않는 방법
//        .subscribe(
//            {
//                Log.d("lastNewJeans", "onNext : $it")
//
//            },
//            {
//                Log.d("lastNewJeans", "onError ${it}")
//            }
//        ).let { _ -> }
//
//        distinct()
////        .distinct {
////            it.age
////        }
//            .distinct()
//            .subscribe(
//                {
//                    Log.d("distinct", "onNext : $it")
//
//                },
//                {
//                    Log.d("distinct", "onError ${it}")
//                },
//                {
//                    Log.d("distinct", "중복을 제거")
//                }
//            ).let { _ -> }

        skip()
            .skip(2)
            .subscribe(
                {
                    Log.d("skip", "onNext : $it")

                },
                {
                    Log.d("skip", "onError ${it}")
                },
                {
                    Log.d("skip", "민지와 하니 스킵~")
                }
            ).let { _ -> }

    }
}

val newJeansList = mutableListOf<NewJeans>(
    NewJeans(1, "민지", 20),
    NewJeans(2, "하니", 20),
    NewJeans(3, "다니엘", 19),
    NewJeans(4, "해린", 18),
    NewJeans(5, "혜인", 16),
)

data class NewJeans
    (
    val id: Long,
    val name: String,
    val age: Int
)
