package com.example.jsoup;

public class Team {
    String rank,imgurl,team_name,gp,w,d,l,f,a,gd,p;

    public Team(String rank, String imgurl, String team_name, String gp, String w, String d, String l, String f, String a, String gd, String p) {
        this.rank = rank;
        this.imgurl = imgurl;
        this.team_name = team_name;
        this.gp = gp;
        this.w = w;
        this.d = d;
        this.l = l;
        this.f = f;
        this.a = a;
        this.gd = gd;
        this.p = p;
    }
    public Team(){}

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getGp() {
        return gp;
    }

    public void setGp(String gp) {
        this.gp = gp;
    }

    public String getW() {
        return w;
    }

    public void setW(String w) {
        this.w = w;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getGd() {
        return gd;
    }

    public void setGd(String gd) {
        this.gd = gd;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }
}
