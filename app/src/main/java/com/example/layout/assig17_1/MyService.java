package com.example.layout.assig17_1;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class MyService extends Service {
//A Service is an application component that can perform long-running operations in the background,
// and it does not provide a user interface.
    MediaPlayer mediaPlayer;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
//Base interface for a remotable object, the core part of a lightweight remote procedure call mechanism
// designed for high performance when performing in-process and cross-process calls
    //Return the communication channel to the service. May return null if clients can not bind to the service.
    // The returned IBinder is usually for a complex interface that has been described using aidl.

    @Override
    public void onCreate() {
        //Called when the activity is starting.
        //MediaPlayer class can be used to control playback of audio/video files and streams.
        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.abc);//created media player
        //Return the context of the single, global Application object of the current process
        //adding a audio file in raw folder and get the folder
        mediaPlayer.setLooping(true); // Sets the player to be looping or non-looping with a boolean value.
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Called by the system every time a client explicitly starts the service by calling startService(Intent), providing the arguments it
        // supplied and a unique integer token representing the start request. Do not call this method directly.
       // Parameters
        //intent	Intent: The Intent supplied to startService(Intent), as given. This may be null if the service is being restarted after its process has gone away, and it had previously returned anything except START_STICKY_COMPATIBILITY.
         //       flags	int: Additional data about this start request.
        /*Value is either 0 or combination of START_FLAG_REDELIVERY or START_FLAG_RETRY.

        startId	int: A unique integer representing this specific request to start. Use with stopSelfResult(int).
        Returns
        int	The return value indicates what semantics the system should use for the service's current started state. It may be one of the constants associated with the START_CONTINUATION_MASK bits.
        Value is START_STICKY_COMPATIBILITY, START_STICKY, START_NOT_STICKY or START_REDELIVER_INTENT.*/


        mediaPlayer.start();//starting media player
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        //stoping media player
    }

}