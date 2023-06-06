package com.example.exrxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.constraintlayout.motion.widget.Debug.getLocation
import androidx.constraintlayout.motion.widget.Debug.getLocation2
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers


class MainActivity : AppCompatActivity() {
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

//        skip()
//            .skip(2)
//            .subscribe(
//                {
//                    Log.d("skip", "onNext : $it")
//
//                },
//                {
//                    Log.d("skip", "onError ${it}")
//                },
//                {
//                    Log.d("skip", "민지와 하니 스킵~")
//                }
//            ).let { _ -> }

//        buffer()
//            .buffer(2,)
//            .subscribe(
//                {
//                    Log.d("buffer", "onNext : $it")
//
//                },
//                {
//                    Log.d("buffer", "onError ${it}")
//                },
//                {
//                    Log.d("buffer", "2개씩 묶어서 보낼게요~")
//                }
//            ).let { _ -> }

//        map()
//            .map {
//                it.age + 5
//            }
//            .subscribe(
//                {
//                    Log.d("map", "onNext : $it")
//
//                },
//                {
//                    Log.d("map", "onError ${it}")
//                },
//                {
//                    Log.d("map", "5살 추가")
//                }
//            ).let { _ -> }

//        flatmap()
//            .flatMap {
//                getNewJeansProgile(it.id)
//            }
//            .subscribe(
//                {
//                    Log.d("flatmap", "onNext : $it")
//
//                },
//                {
//                    Log.d("flatmap", "onError ${it}")
//                },
//                {
//                    Log.d("flatmap", "")
//                }
//            ).let { _ -> }

//        groupBy()
//            .groupBy {
//                it.age
//            }
//            .filter{
//                it.key!! >=19
//            }
//            .subscribe(
//                { group ->
//                    group.subscribe(
//                        {
//                            Log.d("groupBy", "key : ${group.key} - value : $it")
//                        }, {
//                            Log.d("groupBy", "onError ${it}")
//                        }
//                    ).let { }
//
//                },
//                {
//                    Log.d("groupBy", "onError ${it}")
//                },
//                {
//                    Log.d("groupBy", "")
//                }
//            ).let { _ -> }
//
//    }

//        newJeansMerge()
//            .subscribe(
//                {
//                    Log.d("newJeansMerge", "onNext : ${it}")
//                },
//                {
//                    Log.d("newJeansMerge", "onError ${it}")
//                },
//                {
//                    Log.d("newJeansMerge", "뉴진스 + 뉴진스")
//                }
//            ).let { _ -> }
//
//        concat()
//            .subscribe(
//                {
//                    Log.d("concat", "onNext : ${it}")
//                },
//                {
//                    Log.d("concat", "onError ${it}")
//                },
//                {
//                    Log.d("concat", "1 ~ 150까지")
//                }
//            ).let { _ -> }

//        startWith()
//            .subscribe(
//                {
//                    Log.d("startWith", "onNext : ${it}")
//                },
//                {
//                    Log.d("startWith", "onError ${it}")
//                },
//                {
//                    Log.d("startWith", "1 ~ 150까지")
//                }
//            ).let { _ -> }

//        zip()
//            .subscribe(
//                {
//                    Log.d("zip", "onNext : ${it}")
//                },
//                {
//                    Log.d("zip", "onError ${it}")
//                },
//                {
//                    Log.d("zip", "zip")
//                }
//            ).let { _ -> }

//        createObservable().subscribe({
//            Log.d("createObservable", "onNext : ${it}")
//        },
//            {
//                Log.d("createObservable", "onError ${it}")
//            },
//            {
//                Log.d("createObservable", "createObservable")
//            }).let { }

//        createSingleObservable().subscribe(
//            {
//            Log.d("createSingleObservable", "onSuccess : ${it}")
//            },
//            {
//                Log.d("createSingleObservable", "onError ${it}")
//            }
//        ).let { }
//
//        createMaybeObservable().subscribe(
//            observerMaybeObservable()
//        )

//        createCompletableObservable().subscribe(
//            observerCompletableObservable()
//        )

//        createFlowableObservable()
////            .onBackpressureDrop()
//            .onBackpressureLatest()
//            .observeOn(Schedulers.io(), false, 12)
//            .subscribe(
//                {
//                    Log.d("createFlowableObservable", "onNext : ${it}")
//                },
//                {
//                    Log.d("createFlowableObservable", "onError ${it}")
//                },
//                {
//                    Log.d("createFlowableObservable", "onComplete")
//                }
//            ).let { }

//        createObservable()
//            .subscribeOn(Schedulers.io())
//            .subscribe(
//                observer()
//            )




    }

    override fun onDestroy() {
//        disposable.dispose()
        Log.d("onDestroy", "onDestroy")
        super.onDestroy()
    }
}

val newJeansList = mutableListOf<NewJeans>(
    NewJeans(1, "민지", 20),
    NewJeans(2, "하니", 20),
    NewJeans(3, "다니엘", 19),
    NewJeans(4, "해린", 18),
    NewJeans(5, "혜인", 16),
)
val newJeansList2 = mutableListOf<NewJeans>(
    NewJeans(1, "민지2", 20),
    NewJeans(2, "하니2", 20),
    NewJeans(3, "다니엘2", 19),
    NewJeans(4, "해린2", 18),
    NewJeans(5, "혜인2", 16),
)

val newJeansProfileList = mutableListOf<NewJeansProfile>(
    NewJeansProfile(
        1,
        "민지",
        20,
        "https://i.namu.wiki/i/lv9_tel_Tb0uMTKu2GLyq1gY4Sh3wYddG064z0UQkOTEMKi1omYumqgpckuP5JQtyCFq2f-c8E51uRHabRg9Ru6NYgkmyimxkMjtXEbq98c9PMJdF0XkDtquZxuflQSoCS7hkzA-hkuYEPwhG2ioOA.webp"
    ),
    NewJeansProfile(
        2,
        "하니",
        20,
        "https://i.namu.wiki/i/GOfWppX0rHef2nGzGaQk1Vc52w30yqMGMwrWmTkyiPt_q6QxpzCYT_udgxbW6gT2yEldgqMNkfSez9DNwVO9kmLqENnlTovqg7Rkf4t8st1YdP2_LEV0a-gfphc5EYTR_cGyo_09swiXT63SYix2-Q.webp"
    ),
    NewJeansProfile(
        3,
        "다니엘",
        19,
        "https://i.namu.wiki/i/BgeXK91A_VVuIMV-8VPMeBrKeUTvrIeKKLlG6DEI6XurjFe9Z-OjFDqB9VcyYNr-sXE-rrVEioFsit29zMC6Dv8K5iYkgKJ8AUU0_V9nm93Rg34JuA-SeEzulF2AQk6M46RrdF2ivufcB-3mxYgr-g.webp"
    ),
    NewJeansProfile(
        4,
        "해린",
        18,
        "https://i.namu.wiki/i/X9iZkGHp4MkW2piBgK6YaD0FZ4SsksGBDGSeqDoEDh8X9Y1a11VEZpg65mykUxqCxeyk8CGxzXIzjc-K00DpIok0-ftDV1L8ujnstR0emaNIjnZCQzn9xcVecqnJP7sJ1-fBSbHbONaKFfyionNy4w.webp"
    ),
    NewJeansProfile(
        5,
        "혜인",
        16,
        "https://i.namu.wiki/i/4StsXr8ljHiUmcJPw7ro9Pd7O-LQsN3fvy5EPML257rzN5BbveG_FSeEopsOmE6vuUGmtJTyELsjwtaDima9XeWkGPW1Yj71r2agxeUaYUXmPY2SQGIougpj5T9f7lLn_vtgK4uUTxvwmeGRfj5V8w.webp"
    ),
)

data class NewJeans
    (
    val id: Long,
    val name: String,
    val age: Int
)

data class NewJeansProfile
    (
    val id: Long,
    val name: String,
    val age: Int,
    val image: String
)
