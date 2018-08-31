package com.example.jkcshop.spellingcard;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.speech.tts.TextToSpeech;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.asksira.loopingviewpager.LoopingPagerAdapter;
import com.asksira.loopingviewpager.LoopingViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class LearnEachAlphabet extends AppCompatActivity {

    int img_res_id;
    int position = 0, array_length = 0;
    String[] text = new String[10];
    int[] id = new int[10];
    ImageView alphabet_img, img, prev, next;
    TextView textView,word_anim;
    private TextToSpeech tts;
    LoopingViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_each_alphabet);


        viewPager = (LoopingViewPager) findViewById(R.id.viewPager);


        String[] a_text = {"APPLE", "ANT", "AXE"};
        int[] a_id = {R.drawable.apple2, R.drawable.ant2, R.drawable.axe};

        Bundle b = getIntent().getExtras();
        final String alphabet = b.getString("alphabet");
        switch (alphabet) {
            case "a":
                img_res_id = R.drawable.a;
                text = a_text;
                id = a_id;
                break;
            case "b":
                img_res_id = R.drawable.b;
                break;
            case "c":
                img_res_id = R.drawable.c;
                break;

        }


        //textView = (TextView) findViewById(R.id.text);
        //word_anim = (TextView) findViewById(R.id.text);
       // alphabet_img = (ImageView) findViewById(R.id.alphabet2);
       // img = (ImageView) findViewById(R.id.img);
        prev = (ImageView) findViewById(R.id.prev);
        next = (ImageView) findViewById(R.id.next);

        array_length = text.length;
        if (array_length > 1)
            next.setVisibility(View.VISIBLE);


       // alphabet_img.setImageResource(img_res_id);
      //  textView.setText(text[position]);
      //  word_anim.setText("");
        //img.setImageResource(id[position]);
        List<Model> NewModelList = new ArrayList<>();
        Model mod= new Model();

        mod.setImg(id[position]);
        mod.setName(text[position]);
        mod.setAlphabet(img_res_id);

        NewModelList.add(0,mod);
        NewModelList.add(1,mod);
        NewModelList.add(2,mod);


        PagerAdapter adapter = new CustomAdapter(getApplicationContext(), NewModelList,true);
        viewPager.setAdapter(adapter);






        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position != 0) {
                    position = position - 1;


                    List<Model> NewModelList = new ArrayList<>();
                    Model mod= new Model();

                    mod.setImg(id[position]);
                    mod.setName(text[position]);
                    mod.setAlphabet(img_res_id);

                    NewModelList.add(0,mod);
                    NewModelList.add(1,mod);
                    NewModelList.add(2,mod);


                    PagerAdapter adapter = new CustomAdapter(getApplicationContext(), NewModelList,true);
                    viewPager.setAdapter(adapter);

                    next.setVisibility(View.VISIBLE);



//                    img.setImageResource(id[position]);
//                  //  textView.setText(text[position]);
//
//                    word_anim.setText("");
////
//                    for (int i=0;i<text[position].length();)
//                    {
//                        // word_anim.append(Character.toString(text[position].charAt(i)));
//                        ConvertTextToSpeech(Character.toString(text[position].charAt(i)));
////                                sleep(500);
//                        i=i+1;
//                    }
//
//                    final int[] i = new int[1];
//                    i[0] = 0;
//                    final int length = text[position].length();
//                    final Handler handler = new Handler()
//                    {
//                        @Override
//                        public void handleMessage(Message msg) {
//                            super.handleMessage(msg);
//                            char c= text[position].charAt(i[0]);
//                            //ConvertTextToSpeech(Character.toString(text[position].charAt(i[0])));
//                            word_anim.append(String.valueOf(c));
//                            i[0]++;
//                        }
//                    };
//
//                    final Timer timer = new Timer();
//                    TimerTask taskEverySplitSecond = new TimerTask() {
//                        @Override
//                        public void run() {
//                            handler.sendEmptyMessage(0);
//                            if (i[0] == length - 1) {
//                                timer.cancel();
//                            }
//                        }
//                    };
//                    timer.schedule(taskEverySplitSecond, 1, 500);
//
//
//
//                    ConvertTextToSpeech(text[position]);
                    if (position == 0)
                        prev.setVisibility(View.GONE);
                } else {
                    prev.setVisibility(View.GONE);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position != array_length - 1) {
                    position = position + 1;



                    List<Model> NewModelList = new ArrayList<>();
                    Model mod= new Model();

                    mod.setImg(id[position]);
                    mod.setName(text[position]);
                    mod.setAlphabet(img_res_id);

                    NewModelList.add(0,mod);
                    NewModelList.add(1,mod);
                    NewModelList.add(2,mod);


                    PagerAdapter adapter = new CustomAdapter(getApplicationContext(), NewModelList,true);
                    viewPager.setAdapter(adapter);






                   // img.setImageResource(id[position]);
                   // textView.setText(text[position]);
                    prev.setVisibility(View.VISIBLE);
                    //word_anim.setText("");
//                    for (int i=0;i<text[position].length();)
//                    {
//                        // word_anim.append(String.valueOf(text[position].charAt(i)));
//                        ConvertTextToSpeech(Character.toString(text[position].charAt(i)));
//                        // sleep(500);
//                        i=i+1;
//                    }
//                    //   TextView tv= (TextView)HomeActivity.tf.getView().findViewById(R.id.textViewFragment);
//                    final int[] i = new int[1];
//                    i[0] = 0;
//                    final int length = text[position].length();
//                    final Handler handler = new Handler()
//                    {
//                        @Override
//                        public void handleMessage(Message msg) {
//                            super.handleMessage(msg);
//                            char c= text[position].charAt(i[0]);
//                            Log.d("Strange",""+c);
//                            word_anim.append(String.valueOf(c));
//                            i[0]++;
//                        }
//                    };
//
//                    final Timer timer = new Timer();
//                    TimerTask taskEverySplitSecond = new TimerTask() {
//                        @Override
//                        public void run() {
//                            handler.sendEmptyMessage(0);
//                            if (i[0] == length - 1) {
//                                timer.cancel();
//                            }
//                        }
//                    };
//                    timer.schedule(taskEverySplitSecond, 1, 500);
//
//                    ConvertTextToSpeech(text[position]);

                    if (position == array_length - 1) {
                        next.setVisibility(View.GONE);
                    }else {
                        next.setVisibility(View.VISIBLE);
                    }


                } else {
                    next.setVisibility(View.GONE);
                }

            }
        });


    }
    public class CustomAdapter extends LoopingPagerAdapter<Model> {

        public CustomAdapter(Context context, List<Model> itemList, boolean isInfinite) {
            super(context, (ArrayList<Model>) itemList, isInfinite);
        }

        //This method will be triggered if the item View has not been inflated before.
        @Override
        protected View inflateView(int viewType, int listPosition) {
            return LayoutInflater.from(context).inflate(R.layout.item_new, null);
        }

        //Bind your data with your item View here.
        //Below is just an example in the demo app.
        //You can assume convertView will not be null here.
        //You may also consider using a ViewHolder pattern.
        @Override
        protected void bindView(View convertView, int listPosition, int viewType) {
//            convertView.findViewById(R.id.image).setBackgroundColor(context.getResources().getColor(getBackgroundColor(listPosition)));
//            TextView description = convertView.findViewById(R.id.description);
//            description.setText(String.valueOf(itemList.get(listPosition)));

            ImageView imageView = (ImageView) convertView.findViewById(R.id.alphabet2);
            ImageView imageView1 = (ImageView) convertView.findViewById(R.id.img);
            final TextView textView = (TextView) convertView.findViewById(R.id.text);

            if (listPosition==0){
                imageView1.setVisibility(View.VISIBLE);
                imageView.setImageResource(itemList.get(position).getAlphabet());
//                imageView1.setImageResource(itemList.get(position).getImg());
                imageView1.setImageBitmap(ImageNicer.decodeSampledBitmapFromResource(getApplicationContext().getResources(),itemList.get(position).getImg(),100,100));

                textView.setVisibility(View.GONE);

//                Toast.makeText(LearnEachAlphabet.this, String.valueOf(listPosition), Toast.LENGTH_SHORT).show();
            }
            else if (listPosition==1){
                textView.setVisibility(View.VISIBLE);
                imageView.setImageResource(itemList.get(position).getAlphabet());
                imageView1.setVisibility(View.GONE);

//                Toast.makeText(LearnEachAlphabet.this, String.valueOf(listPosition), Toast.LENGTH_SHORT).show();



                tts = new TextToSpeech(LearnEachAlphabet.this, new TextToSpeech.OnInitListener() {

                    @Override
                    public void onInit(int status) {
                        // TODO Auto-generated method stub
                        if (status == TextToSpeech.SUCCESS) {
                            sleep(4000);
                            int result = tts.setLanguage(Locale.ENGLISH);
                            tts.setSpeechRate(0.1f);
                            if (result == TextToSpeech.LANG_MISSING_DATA ||
                                    result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                Log.e("error", "This Language is not supported");
                            } else {

                                final int length =itemList.get(position).getName().length();
                                for (int i=0;i<length;)
                                {
                                    // word_anim.append(Character.toString(text[position].charAt(i)));
                                    ConvertTextToSpeech(Character.toString(itemList.get(position).getName().charAt(i)));
                                    //sleep(500);
                                    i=i+1;
                                }

                                final int[] i = new int[1];
                                i[0] = 0;


                                final Handler handler = new Handler()
                                {
                                    @Override
                                    public void handleMessage(Message msg) {

                                        try {
                                        super.handleMessage(msg);
                                        char c= itemList.get(position).getName().charAt(i[0]);

                                        textView.append(String.valueOf(c));
                                        // ConvertTextToSpeech(Character.toString(text[position].charAt(i[0])));
                                        i[0]++;

                                    }catch (IndexOutOfBoundsException iobe){

                                    Toast.makeText(LearnEachAlphabet.this, "ghhf", Toast.LENGTH_SHORT).show();
                                }
                                    }
                                };

                                final Timer timer = new Timer();
                                TimerTask taskEverySplitSecond = new TimerTask() {
                                    @Override
                                    public void run() {
                                        handler.sendEmptyMessage(0);
                                        if (i[0] == length - 1) {
                                            timer.cancel();
                                        }
                                    }
                                };
                                timer.schedule(taskEverySplitSecond, 1, 500);

                                ConvertTextToSpeech(itemList.get(position).getName());

                            }
                        } else
                            Log.e("error", "Initilization Failed!");
                    }
                });







            }
            else if (listPosition==2){

//                Toast.makeText(LearnEachAlphabet.this, String.valueOf(listPosition), Toast.LENGTH_SHORT).show();
                textView.setVisibility(View.VISIBLE);
                imageView1.setVisibility(View.VISIBLE);
                imageView.setImageResource(itemList.get(position).getAlphabet());
//                imageView1.setImageResource(itemList.get(position).getImg());

                imageView1.setImageBitmap(ImageNicer.decodeSampledBitmapFromResource(getApplicationContext().getResources(),itemList.get(position).getImg(),100,100));

                textView.setText(itemList.get(position).getName());
            }



        }
    }








    @Override
    protected void onPause() {
        // TODO Auto-generated method stub

        if (tts != null) {

            tts.stop();
            tts.shutdown();
        }
        super.onPause();
    }



    private void ConvertTextToSpeech(String s) {
        // TODO Auto-generated method stub

        tts.speak(s, TextToSpeech.QUEUE_ADD, null);


    }


    public void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }


}
