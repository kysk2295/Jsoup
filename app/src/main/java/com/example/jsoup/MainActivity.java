package com.example.jsoup;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Context context;
    Spinner spinner;
    ArrayList<String> season;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> ranks= new ArrayList<>();
    ArrayList<Team> datas= new ArrayList<>();
    String url="https://www.espn.com/soccer/standings/_/league/ENG.1/season/2018";


    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=MainActivity.this;
        recyclerView=findViewById(R.id.recyclerview_rank);
        spinner=findViewById(R.id.main_textview_season);

        season=new ArrayList<>();
        season.add("2019-2020");
        season.add("2018-2019");
        season.add("2017-2018");
        season.add("2016-2017");
        season.add("2015-2016");
        season.add("2014-2015");
        season.add("2013-2014");

        arrayAdapter= new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,season);
        spinner.setAdapter(arrayAdapter);

        spinner.setSelection(1);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        url="https://www.espn.com/soccer/standings/_/league/ENG.1";
                        datas.clear();
                        new Task().execute();
                        break;
                    case 1:
                        url="https://www.espn.com/soccer/standings/_/league/ENG.1/season/2018";
                        datas.clear();
                        new Task().execute();
                        break;
                    case 2:
                        url="https://www.espn.com/soccer/standings/_/league/ENG.1/season/2017";
                        datas.clear();
                        new Task().execute();
                        break;
                    case 3:
                        url="https://www.espn.com/soccer/standings/_/league/ENG.1/season/2016";
                        datas.clear();
                        new Task().execute();
                        break;
                    case 4:
                        url="https://www.espn.com/soccer/standings/_/league/ENG.1/season/2015";
                        datas.clear();
                        new Task().execute();
                        break;
                    case 5:
                        url="https://www.espn.com/soccer/standings/_/league/ENG.1/season/2014";
                        datas.clear();
                        new Task().execute();
                        break;
                    case 6:
                        url="https://www.espn.com/soccer/standings/_/league/ENG.1/season/2013";
                        datas.clear();
                        new Task().execute();
                        break;
            }

        }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });

        new Task().execute();


    }

    private class Task extends AsyncTask<Void, Void, ArrayList<Team>> {


        @Override
        protected ArrayList<Team> doInBackground(Void... voids) {
            try {
                int n=0;
                int s=0;
                int cnt=1;

                Document document = Jsoup.connect(url).get();
                Elements ele= document.select("div[class=team-link flex items-center clr-gray-03]");
                Elements ele2=document.select("tr[class=Table2__tr Table2__tr--sm Table2__even]");
                Elements ele3=document.select("tr[class=filled Table2__tr Table2__tr--sm Table2__even]");

                for(Element element:ele){

                    Element i,i2;

                    String rank=element.select("span[class=team-position ml2 pr3]").text();
                    String imgUrl=element.select("span[class=pr4 TeamLink__Logo]")
                            .select("a img")
                            .attr("src");
                    String teamname=element.select("span[class=hide-mobile] a")
                            .text();

                    if((cnt)%2==0){
                        i2=ele3.get(s+10);

                        String gp=i2.select("td[class=Table2__td]:eq(0)>span[class=stat-cell]").text();
                        String w=i2.select("td[class=Table2__td]:eq(1)>span[class=stat-cell]").text();
                        String d=i2.select("td[class=Table2__td]:eq(2)>span[class=stat-cell]").text();
                        String l=i2.select("td[class=Table2__td]:eq(3)>span[class=stat-cell]").text();
                        String f=i2.select("td[class=Table2__td]:eq(4)>span[class=stat-cell]").text();
                        String a=i2.select("td[class=Table2__td]:eq(5)>span[class=stat-cell]").text();
                        String gd=i2.select("td[class=Table2__td]:eq(6)>span[class=stat-cell]").text();
                        String p=i2.select("td[class=Table2__td]:eq(7)>span[class=stat-cell]").text();

                        Team team= new Team(rank,imgUrl,teamname,gp,w,d,l,f,a,gd,p);
                        datas.add(team);
                        s++;
                        Log.d("Team",team.getRank()+"\n"+team.getImgurl()+"\n"+team.getTeam_name()+"\n"+team.getGp()+"\n"+team.getW()+"\n"+team.getD()+"\n"+team.getL()+"\n"+team.getF()+"\n"+team.getA()+"\n"+team.getGd()+"\n"+team.getP()+"\n"+String.valueOf(n)+"\n"+s);
                    }else{

                        Log.d("fail","else문으로 들어왔다");
                        i = ele2.get(n+10);

                        String gp=i.select("td[class=Table2__td]:eq(0)>span[class=stat-cell]").text();
                        String w=i.select("td[class=Table2__td]:eq(1)>span[class=stat-cell]").text();
                        String d=i.select("td[class=Table2__td]:eq(2)>span[class=stat-cell]").text();
                        String l=i.select("td[class=Table2__td]:eq(3)>span[class=stat-cell]").text();
                        String f=i.select("td[class=Table2__td]:eq(4)>span[class=stat-cell]").text();
                        String a=i.select("td[class=Table2__td]:eq(5)>span[class=stat-cell]").text();
                        String gd=i.select("td[class=Table2__td]:eq(6)>span[class=stat-cell]").text();
                        String p=i.select("td[class=Table2__td]:eq(7)>span[class=stat-cell]").text();

                        Team team= new Team(rank,imgUrl,teamname,gp,w,d,l,f,a,gd,p);
                        datas.add(team);
                        n++;
                        Log.d("Team",team.getRank()+"\n"+team.getImgurl()+"\n"+team.getTeam_name()+"\n"+team.getGp()+"\n"+team.getW()+"\n"+team.getD()+"\n"+team.getL()+"\n"+team.getF()+"\n"+team.getA()+"\n"+team.getGd()+"\n"+team.getP()+"\n"+String.valueOf(n)+"\n"+s);
                    }

                    cnt++;

                }


            } catch (IOException e) {
                e.printStackTrace();
            }
            return datas;
        }

        @Override
        protected void onPostExecute(ArrayList<Team> teams) {
            super.onPostExecute(teams);

            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            recyclerView.setAdapter(new RankAdapter(context,datas));

        }
    }
}
