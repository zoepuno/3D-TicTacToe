public class Count
{
    private int[] opponent = new int[4];
    private int[] myself = new int[4];

    public int[] getOpponent() {
        return opponent;
    }
    public int[] getMyself() {
        return myself;
    }

    private Board board;
    private Location loc;
    private char me, opp;

    public void calculate(Board board, Location location,char player)
    {
        this.board = board;
        this.loc = location;
        this.me = player;
        opp = (player=='x')?'o':'x';
        calculate();
    }

    public void calculate()
    {
        opponent = new int[4];
        myself = new int[4];
        int c = loc.getCol();
        int r = loc.getRow();
        int s = loc.getSheet();
        char[][][] b = board.getData();
    //horizontals
        //my horizontal
        int count = 1;
        for(int cc = 0;cc<4;cc++)
        {
            if(b[s][r][cc]==me)
            {
                count++;
            }
            else if(b[s][r][cc]==opp)
            {
                count = 0;
                break;
            }
        }
        addMe(count);

        //enemy horizontal
        count = 1;
        for(int cc = 0;cc<4;cc++)
        {
            if(b[s][r][cc]==opp)
            {
                count++;
            }
            else if(b[s][r][cc]==me)
            {
                count = 0;
                break;
            }
        }
        addOpp(count);

    //vertical
        //my vertical
        count = 1;
        for(int rr = 0;rr<4;rr++)
        {
            if(b[s][rr][c]==me)
            {
                count++;
            }
            else if(b[s][rr][c]==opp)
            {
                count = 0;
                break;
            }
        }
        addMe(count);

        //opp vertical
        count = 1;
        for(int rr = 0;rr<4;rr++)
        {
            if(b[s][rr][c]==opp)
            {
                count++;
            }
            else if(b[s][rr][c]==me)
            {
                count = 0;
                break;
            }
        }
        addOpp(count);

    //backwards
        //my backwards
        count = 1;
        for(int ss = 0;ss<4;ss++)
        {
            if(b[ss][r][c]==me)
            {
                count++;
            }
            else if(b[ss][r][c]==opp)
            {
                count = 0;
                break;
            }
        }
        addMe(count);

        //opp backwards
        count = 1;
        for(int ss = 0;ss<4;ss++)
        {
            if(b[ss][r][c]==opp)
            {
                count++;
            }
            else if(b[ss][r][c]==me)
            {
                count=0;
                break;
            }
        }
        addOpp(count);

    //z sheet diagonal
        if(c==r)
        {
            //my z sheet diagonal
            count = 1;
            for(int aa = 0;aa<4;aa++)
            {
                if(b[s][aa][aa]==me)
                {
                    count++;
                }
                else if(b[s][aa][aa]==opp)
                {
                    count = 0;
                    break;
                }
            }
            addMe(count);

            //opp z sheet diagonal
            count = 1;
            for(int aa = 0;aa<4;aa++)
            {
                if(b[s][aa][aa]==opp)
                {
                    count++;
                }
                else if(b[s][aa][aa]==me)
                {
                    count = 0;
                    break;
                }
            }
            addOpp(count);
        }

    //z diagonal 2
        if(c+r==3)
        {
            //my z diagonal 2
            count = 1;
            for(int aa = 0;aa<4;aa++)
            {
                if(b[s][aa][3-aa]==me)
                {
                    count++;
                }
                else if(b[s][aa][3-aa]==opp)
                {
                    count = 0;
                    break;
                }
            }
            addMe(count);

            //opp z diagonal 2
            count = 1;
            for(int aa = 0;aa<4;aa++)
            {
                if(b[s][aa][3-aa]==opp)
                {
                    count++;
                }
                else if(b[s][aa][3-aa]==me)
                {
                    count = 0;
                    break;
                }
            }
            addOpp(count);
        }

        //y plane diagonal 1
        if(c==s)
        {
            //my y diagonal 1
            count = 1;
            for(int aa = 0;aa<4;aa++)
            {
                if(b[aa][r][aa]==me)
                {
                    count++;
                }
                else if(b[aa][r][aa]==opp)
                {
                    count = 0;
                    break;
                }
            }
            addMe(count);
            //opp y diagonal 1
            count = 1;
            for(int aa = 0;aa<4;aa++)
            {
                if(b[aa][r][aa]==opp)
                {
                    count++;
                }
                else if(b[aa][r][aa]==me)
                {
                    count = 0;
                    break;
                }
            }
            addOpp(count);
        }

//y plane diagonal 2
        if(c+s==3)
        {
            count = 1;
            for(int aa = 0;aa<4;aa++)
            {
                if(b[aa][r][3-aa]==me)
                {
                    count++;
                }
                if(b[aa][r][3-aa]==opp)
                {
                    count=0;
                    break;
                }
            }
            addMe(count);

            count = 1;
            for(int aa = 0;aa<4;aa++)
            {
                if(b[aa][r][3-aa]==opp)
                {
                    count++;
                }
                if(b[aa][r][3-aa]==me)
                {
                    count = 0;
                    break;
                }
            }
            addOpp(count);
        }

//x plane diagonal 1
        if(r==s)
        {
            count = 1;
            for(int aa = 0;aa<4;aa++)
            {
                if(b[aa][aa][c]==me)
                {
                    count++;
                }
                else if(b[aa][aa][c]==opp)
                {
                    count = 0;
                    break;
                }
            }
            addMe(count);

            count = 1;
            for(int aa = 0;aa<4;aa++)
            {
                if(b[aa][aa][c]==opp)
                {
                    count++;
                }
                else if(b[aa][aa][c]==me)
                {
                    count = 0;
                    break;
                }
            }
            addOpp(count);
        }

//x plane diagonal 2
        if(r+s==3)
        {
            count = 1;
            for(int aa = 0;aa<4;aa++)
            {
                if(b[aa][3-aa][c]==me)
                {
                    count++;
                }
                if(b[aa][3-aa][c]==opp)
                {
                    count = 0;
                    break;
                }
            }
            addMe(count);

            count = 1;
            for(int aa = 0;aa<4;aa++)
            {
                if(b[aa][3-aa][c]==opp)
                {
                    count++;
                }
                if(b[aa][3-aa][c]==me)
                {
                    count = 0;
                    break;
                }
            }
            addOpp(count);
        }

//special diagonal 1
        if(r==s&&r==c)
        {
            //special diagonal 1 me
            count = 1;
            for(int aa = 0;aa<4;aa++)
            {
                if(b[aa][aa][aa]==me)
                {
                    count++;
                }
                else if(b[aa][aa][aa]==opp)
                {
                    count = 0;
                    break;
                }
            }
            addMe(count);

            //special diagonal 1 opp
            count = 1;
            for(int aa = 0;aa<4;aa++)
            {
                if(b[aa][aa][aa]==opp)
                {
                    count++;
                }
                else if(b[aa][aa][aa]==me)
                {
                    count = 0;
                    break;
                }

            }
            addOpp(count);
        }

        //special diagonal 2
        if((c==3&&r==0&&s==0)||(c==2&&r==1&&s==1)||(c==1&&r==2&&s==2)||(c==0&&r==3&&s==3))
        {
            //special diagonal 2 me
            count = 1;
            for(int aa = 0;aa<4;aa++)
            {
                if(b[aa][aa][3-aa]==me)
                {
                    count++;
                }
                else if(b[aa][aa][3-aa]==opp)
                {
                    count = 0;
                    break;
                }
            }
            addMe(count);

            //special diagonal 2 opp
            count = 1;
            for(int aa = 0;aa<4;aa++)
            {
                if(b[aa][aa][3-aa]==opp)
                {
                    count++;
                }
                else if(b[aa][aa][3-aa]==me)
                {
                    count = 0;
                    break;
                }
            }
            addOpp(count);
        }

        //special diagonal 3
        if((c==0&&r==0&&s==3)||(c==1&&r==1&&s==2)||(c==2&&r==2&&s==1)||(c==3&&r==3&&s==0))
        {
            //special diagonal 3 me
            count = 1;
            for(int aa = 0;aa<4;aa++)
            {
                if(b[3-aa][aa][aa]==me)
                {
                    count++;
                }
                if(b[3-aa][aa][aa]==opp)
                {
                    count = 0;
                    break;
                }
            }
            addMe(count);

            //special diagonal 3 opp
            count = 1;
            for(int aa = 0;aa<4;aa++)
            {
                if(b[3-aa][aa][aa]==opp)
                {
                    count++;
                }
                if(b[3-aa][aa][aa]==me)
                {
                    count = 0;
                    break;
                }
            }
            addOpp(count);
        }

        //special diagonal 4
        if((c==3 && r==0 && s==3) || (c==2 && r==1 && s==2) || (c==1 && r==2 && s==1) || (c==0 && r==3 && s==0))
        {
            //special diagonal 4 me
            count = 1;
            for(int aa = 0;aa<4;aa++)
            {
                if(b[3-aa][aa][3-aa]==me)
                {
                    count++;
                }
                if(b[3-aa][aa][3-aa]==opp)
                {
                    count = 0;
                    break;
                }
            }
            addMe(count);

            //special diagonal 4 opp
            count = 1;
            for(int aa = 0;aa<4;aa++)
            {
                if(b[3-aa][aa][3-aa]==opp)
                {
                    count++;
                }
                if(b[3-aa][aa][3-aa]==me)
                {
                    count = 0;
                    break;
                }
            }
            addOpp(count);
        }
    }

    public void addMe(int c)
    {
        if(c>0)
        {
            myself[c-1] = myself[c-1]+1;
        }
    }

    public void addOpp(int c)
    {
        if(c>0)
        {
            opponent[c-1] = opponent[c-1]+1;
        }
    }
}

