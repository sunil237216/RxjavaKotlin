package com.example.rxjavaclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.AsyncSubject
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.ReplaySubject
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        createTimer().subscribe { a ->
//            println("time is seconds is "+a)
//        }

//        createFromArray().subscribe { arr ->
//
//            println("received array is "+Arrays.toString(arr));
//        }

//        createFromInterval().subscribe { arr ->
//          println("received array is "+arr);
//       }
//        createTimer().subscribe { arr ->
//            println("food is prepared after "+arr);
//        }

//        createflatmap().subscribe{test ->
//            println("filtered item are "+test);
//        }


//        val professor = PublishSubject.create<String>()
//
//        professor.subscribe(getfirstStudent())
//        professor.onNext("kotlin");
//        professor.onNext("java");
//        professor.onNext("c++");
//
//        professor.subscribe(getlastStudent())
//        professor.onNext("scala")
//        professor.onComplete()

//                val professor = ReplaySubject
//                    .create<String>()
//        professor.subscribe(getfirstStudent())
//        professor.onNext("kotlin");
//        professor.onNext("java");
//        professor.onNext("c++");
//        professor.subscribe(getlastStudent())
//        professor.onNext("scala")
//        professor.onComplete()

//        val professor = ReplaySubject
//            .create<String>()
//        professor.subscribe(getfirstStudent())
//        professor.onNext("kotlin");
//        professor.onNext("java");
//        professor.onNext("c++");
//        professor.subscribe(getlastStudent())
//        professor.onNext("scala")
//        professor.onComplete()

//        val professor = BehaviorSubject
//            .create<String>()
//        professor.subscribe(getfirstStudent())
//        professor.onNext("kotlin");
//        professor.onNext("java");
//        professor.onNext("c++");
//        professor.subscribe(getlastStudent())
//        professor.onNext("scala")
//        professor.onComplete()

        val professor = AsyncSubject
            .create<String>()
        professor.subscribe(getfirstStudent())
        professor.onNext("kotlin");
        professor.onNext("java");
        professor.onNext("c++");
        professor.subscribe(getlastStudent())
        professor.onNext("scala")
        professor.onComplete()


    }

    private fun  showjustJob()
    {
                val dataSource = Observable.just(10,20,30,40)

        val Observer = object :Observer<Int>
        {
            override fun onComplete() {
               println("all data is received.....")
            }

            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: Int) {

                println("new data is recieved.... "+t)

            }

            override fun onError(e: Throwable) {

            }
        }
        dataSource.subscribe(Observer)




    }

    private fun createTimer() : Observable<Long>
    {
        return Observable.timer(5,TimeUnit.SECONDS)
    }
    private fun createFromArray():Observable<Array<Int>>
    {
        return Observable.fromArray(arrayOf(2,3,4,5,6));
    }
    private fun createFromIterator():Observable<Int>
    {
        return Observable.fromIterable(mutableListOf(2,3,4,5,6));
    }
    private fun createFromRange():Observable<Int>
    {
        return Observable.range(1,10);
    }

    private fun createFromInterval():Observable<Long>
    {
        return Observable.interval(1,TimeUnit.SECONDS).takeWhile { value -> value<20 }
    }

    private fun createFromtimer():Observable<Long>
    {
        return Observable.timer(
            5,TimeUnit.SECONDS)
    }
    private fun createfilter():Observable<Int>
    {
        return Observable.just(1,10,20,4 ,7).filter { it>10 };
    }
  //  http://s3-ap-south-1.amazonaws.com/adkandivali/foundryRealTimeThreshold.html

    private fun createmap():Observable<Int>
    {
        return Observable.just(1,10,20,4 ,7).map{it*20}
    }
    private fun createflatmap():Observable<String>
    {
        return Observable.just(1,2).flatMap{id -> getName(id) }
    }
    private fun getName(id:Int):Observable<String>
    {
        println(id);
        val names = arrayOf("test","test1","test2")
        return Observable.just(names[id])
    }

    private fun getfirstStudent():Observer<String> {
        return object : Observer<String>{
            override fun onComplete() {

                println("lecture is ended");

            }

            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: String) {
                println("frist student  ==>  professor teaches "+t)
            }

            override fun onError(e: Throwable) {
                println("Error");
            }

        }

    }
    private fun getlastStudent():Observer<String> {
        return object : Observer<String>{
            override fun onComplete() {
                println("lecture is ended");
            }

            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: String) {
                println("last student ==> professor teaches "+t);
            }

            override fun onError(e: Throwable) {
                println("Error");
            }

        }

    }

}
