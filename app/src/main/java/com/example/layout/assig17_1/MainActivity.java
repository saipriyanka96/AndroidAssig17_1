package com.example.layout.assig17_1;
//Package objects contain version information about the implementation and specification of a Java package
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //public keyword is used in the declaration of a class,method or field;public classes,method and fields can be accessed by the members of any class.
//extends is for extending a class. implements is for implementing an interface
//AppCompatActivity is a class from e v7 appcompat library. This is a compatibility library that back ports some features of recent versions of
// Android to older devices.
//View.OnClickListener:Interface definition for a callback to be invoked when a view is clicked.
    //Declaration
    Button start_btn,stop_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Variables, methods, and constructors, which are declared protected in a superclass can be accessed only by the subclasses
        // in other package or any class within the package of the protected members class.
        //void is a Java keyword.  Used at method declaration and definition to specify that the method does not return any type,
        // the method returns void.
        //onCreate Called when the activity is first created. This is where you should do all of your normal static set up: create views,
        // bind data to lists, etc. This method also provides you with a Bundle containing the activity's previously frozen state,
        // if there was one.Always followed by onStart().
        //Bundle is most often used for passing data through various Activities.
// This callback is called only when there is a saved instance previously saved using onSaveInstanceState().
// We restore some state in onCreate() while we can optionally restore other state here, possibly usable after onStart() has
// completed.The savedInstanceState Bundle is same as the one used in onCreate().

        super.onCreate(savedInstanceState);
// call the super class onCreate to complete the creation of activity like the view hierarchy
        setContentView(R.layout.activity_main);
        //R means Resource
        //layout means design
        //  main is the xml you have created under res->layout->main.xml
        //  Whenever you want to change your current Look of an Activity or when you move from one Activity to another .
        // The other Activity must have a design to show . So we call this method in onCreate and this is the second statement to set
        // the design
        //setting up UI component
        //Finds a view that was identified by the android:id XML attribute that was processed in onCreate(Bundle).
        start_btn = (Button) findViewById(R.id.strt_btn);
        stop_btn = (Button) findViewById(R.id.stop_btn);
        start_btn.setOnClickListener(this);//setting btn
        stop_btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        //Called when a view has been clicked.
        //applying condition for start and stop the music
        switch (view.getId()){
            //we get the id here
            case R.id.strt_btn:// Play audio
                startService(new Intent(this, MyService.class));
             //Request that a given application service be started.
                //Make a standard toast that just contains a text view with the text from a resource.

                //Parameters
                //context	Context: The context to use. Usually your Application or Activity object.
                //resId	int: The resource id of the string resource to use. Can be formatted text.
                //duration	int: How long to display the message. Either LENGTH_SHORT or LENGTH_LONG
//show():shows the data
                Toast.makeText(this, "Start Music", Toast.LENGTH_LONG).show();
                break;
            case R.id.stop_btn:// Pause audio
                stopService(new Intent(this, MyService.class));
            //Request that a given application service be started
                Toast.makeText(this, "Stop Music", Toast.LENGTH_LONG).show();
                break;

        }
    }
}