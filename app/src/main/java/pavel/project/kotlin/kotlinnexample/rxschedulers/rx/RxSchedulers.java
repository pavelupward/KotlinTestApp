package pavel.project.kotlin.kotlinnexample.rxschedulers.rx;

import io.reactivex.Scheduler;

public interface RxSchedulers {


    Scheduler runOnBackground();

    Scheduler io();

    Scheduler compute();

    Scheduler androidThread();

    Scheduler internet();



}
