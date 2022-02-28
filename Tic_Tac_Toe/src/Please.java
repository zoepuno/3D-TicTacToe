public class Please implements PlayerInt {

    private char letter;
    private String name;
    private Counts counts = new Counts();
    String studentName = "";
    private int[] opps = new int[4];
    private int[] mys = new int[4];
    private Board board;
    private Location loc;
    private char me, opp;
    public int[] getOpps() {
        return opps;
    }
    public int[] getMys() {
        return mys;
    }
    public Board getBoard() {
        return board;
    }

    Please(char letter) {
        name      = "In A Day";
        this.letter    = letter;
        this.studentName=" Zoe Puno & Jessica Sollars";
    }


    public char getLetter() {
        return letter;
    }
    @Override
    public String getStudentName(){
        return studentName;
    }

    @Override
    public Location getMove(char[][][] board){
        Board b = new Board(board);
        int max = -1;
        int circle;
        int row;
        int col;
        int sheet;
        Location best = null;

        for(int y = 0; y < 4; y++) {
            for (int z = 0; z < 4; z++) {
                for (int x = 0; x < 4; x++) {
                    Location l = new Location(z,y,x);
                    if(b.isEmpty(l)) {
                        calculate(b,l,letter);
                        int score = getMys()[0]*10+getMys()[1]*3000+getMys()[2]*3500+getMys()[3]*1000000+getOpps()[0]+getOpps()[1]*1000+getOpps()[2]*3000+getOpps()[3]*100000;

                        if(score>max) {
                            max = score;
                            best = l;
                        }
                    }
                }
            }
        }
        //sheet check
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                sheet=0;
                circle=0;
                for (int s = 0; s < 4; s++) {
                    if (b.getLocation(c,r,s)== getLetter()) {
                        sheet++;
                    }
                    if (!(b.getLocation(c, r, s) == getLetter()) && !(b.getLocation(c, r, s) == '-')) {
                        circle++;
                    }
                    if (circle==0 && sheet==3) {
                        for (int so = 0; so < 4; so++) {
                            if (b.getLocation(c, r, so) == '-') {
                                best = new Location(c, r, so);
                                return best;
                            }
                        }
                    }
                    if (circle==3 && sheet==0) {
                        for (int so = 0; so < 4; so++) {
                            if (b.getLocation(c, r, so) == '-') {
                                best = new Location(c, r, so);
                                return best;
                            }
                        }
                    }
                }
            }
        }
//col
        for (int r = 0; r < 4; r++) {
            for (int s = 0; s < 4; s++) {
                circle=0;
                col = 0;
                for (int c = 0; c < 4; c++) {
                    if (b.getLocation(c, r, s) == getLetter()) {
                        col++;
                    }
                    if (!(b.getLocation(c, r, s) == getLetter()) && !(b.getLocation(c, r, s) == '-')) {
                        circle++;
                    }
                    if (circle==0 && col==3) {
                        for (int co = 0; co < 4; co++) {
                            if (b.getLocation(co, r, s) == '-'){
                                best = new Location(co, r, s);
                                return best;

                            }
                        }
                    }
                    if (circle==3 && col==0) {
                        for (int co = 0; co < 4; co++) {
                            if (b.getLocation(co, r, s) == '-'){
                                best = new Location(co, r, s);
                                return best;

                            }
                        }
                    }
                }
            }
        }
        //row check
        for (int s = 0; s < 4; s++) {
            for (int c = 0; c < 4; c++) {
                circle=0;
                row = 0;
                for (int r = 0; r < 4; r++) {
                    if (b.getLocation(c, r, s) == getLetter()) {
                        row++;
                    }
                    if (!(b.getLocation(c, r, s) == getLetter()) && !(b.getLocation(c, r, s) == '-')) {
                        circle++;
                    }
                    if (circle==0 && row==3) {
                        for (int ro = 0; ro < 4; ro++) {
                            if (b.getLocation(c, ro, s) == '-' ) {
                                best = new Location(c, ro, s);
                                return best;

                            }
                        }
                    }
                    if (circle==3 && row==0) {
                        for (int ro = 0; ro < 4; ro++) {
                            if (b.getLocation(c, ro, s) == '-' ) {
                                best = new Location(c, ro, s);
                                return best;

                            }
                        }
                    }

                }

            }
        }
        return best;
    }

    // Pre:       method is called
    // Post:   returns the name of the player
    public String getName() {
        return name;
    }

    @Override
    public void refresh() {

    }

    public void freshCopy(){
        new Please(letter);
    }
    public void calculate(Board board, Location loc , char me)
    {
        this.board = board;
        this.loc = loc;
        this.me = me;

        int c = loc.getCol();
        int r = loc.getRow();
        int s = loc.getSheet();

        char[][][] b = board.getData();
        //horizontals
        //my horizontal
        int count = 1;
        for(int col = 0;col<4;col++) {

            if(b[s][r][col]== me) {
                count++;
            }

            else if(b[s][r][col]==opp) {
                count = 0;
                break;
            }
        }
        addMe(count);

        //enemy horizontal
        count = 1;
        for(int col = 0;col<4;col++) {

            if(b[s][r][col]==opp) {
                count++;
            }

            else if(b[s][r][col]==me) {
                count = 0;
                break;
            }
        }
        addOpp(count);
        //vertical
        //my vertical

        count = 1;
        for(int row = 0;row<4;row++) {

            if(b[s][row][c]==me) {
                count++;
            }

            else if(b[s][row][c]==opp){
                count = 0;
                break;
            }
        }

        addMe(count);
        //opp vertical
        count = 1;
        for(int row = 0;row<4;row++)
        {
            if(b[s][row][c]==opp) {
                count++;
            }

            else if(b[s][row][c]==me)
            {
                count = 0;
                break;
            }
        }
        addOpp(count);
        //backwards
        //my backwards
        count = 1;
        for(int shee = 0;shee<4;shee++) {

            if(b[shee][r][c]==me) {
                count++;
            }

            else if(b[shee][r][c]==opp)
            {
                count = 0;
                break;
            }
        }
        addMe(count);
        //opp backwards
        count = 1;
        for(int sheet = 0;sheet<4;sheet++)
        {
            if(b[sheet][r][c]==opp) {
                count++;
            }

            else if(b[sheet][r][c]==me) {
                count=0;
                break;
            }
        }
        addOpp(count);
        //z sheet diagonal
        if(c==r) {
            //my z sheet diagonal
            count = 1;
            for(int d = 0;d<4;d++) {

                if(b[s][d][d]==me) {
                    count++;
                }

                else if(b[s][d][d]==opp) {
                    count = 0;
                    break;
                }
            }
            addMe(count);
            //opp z sheet diagonal
            count = 1;

            for(int d = 0;d<4;d++)
            {
                if(b[s][d][d]==opp) {
                    count++;
                }

                else if(b[s][d][d]==me) {
                    count = 0;
                    break;
                }
            }
            addOpp(count);
        }

        //z diagonal 2
        if(c+r==3){
            //my z diagonal 2
            count = 1;
            for(int d = 0;d<4;d++) {
                if(b[s][d][3-d]==me) {
                    count++;
                }
                else if(b[s][d][3-d]==opp) {
                    count = 0;
                    break;
                }
            }
            addMe(count);

            //opp z diagonal 2
            count = 1;
            for(int d = 0;d<4;d++) {
                if(b[s][d][3-d]==opp) {
                    count++;
                }
                else if(b[s][d][3-d]==me) {
                    count = 0;
                    break;
                }
            }
            addOpp(count);
        }
        //y plane diagonal 1
        if(c==s) {
            //my y diagonal 1
            count = 1;
            for(int d = 0;d<4;d++) {

                if(b[d][r][d]==me) {
                    count++;
                }
                else if(b[d][r][d]==opp) {
                    count = 0;
                    break;
                }
            }
            addMe(count);
            //opp y diagonal 1

            count = 1;
            for(int d = 0;d<4;d++) {
                if(b[d][r][d]==opp) {
                    count++;
                }
                else if(b[d][r][d]==me) {
                    count = 0;
                    break;
                }
            }
            addOpp(count);
        }
        //y plane diagonal 2
        if(c+s==3) {
            for(int d = 0;d<4;d++) {
                if(b[d][r][3-d]==me) {
                    count++;
                }
                if(b[d][r][3-d]==opp) {
                    count=0;
                    break;
                }
            }
            addMe(count);
            for(int aa = 0;aa<4;aa++) {
                if(b[aa][r][3-aa]==opp) {
                    count++;
                }
                if(b[aa][r][3-aa] == me) {
                    count = 0;
                    break;
                }
            }
            addOpp(count);
            System.out.println("Blocking diagonal special 2");
        }
        //x plane diagonal 1
        if(r==s) {
            for(int d = 0;d<4;d++) {
                if(b[d][d][c]==me) {
                    count++;
                }
                else if(b[d][d][c]==opp) {
                    count = 0;
                    break;
                }
            }
            addMe(count);
            for(int d = 0;d<4;d++) {

                if(b[d][d][c]==opp) {
                    count++;
                }
                else if(b[d][d][c]==me) {

                    count = 0;
                    break;
                }
            }
            addOpp(count);
            
        }
        //x plane diagonal 2
        if(r+s==3) {
            for(int d = 0;d<4;d++) {

                if(b[d][3-d][c]==me) {
                    count++;
                }

                if(b[d][3-d][c]==opp) {
                    count = 0;
                    break;
                }
            }
            addMe(count);

            for(int d = 0;d<4;d++) {
                if(b[d][3-d][c]==opp) {
                    count++;
                }

                if(b[d][3-d][c]==me) {
                    count = 0;
                    break;
                }
            }
            addOpp(count);
        }

        //special dia 1
        if(r==s && r==c) {
            //special dia 1 me
            count = 1;
            for(int d = 0;d<4;d++) {
                if(b[d][d][d]==me) {
                    count++;
                }
                else if(b[d][d][d]==opp)
                {
                    count = 0;
                    break;
                }
            }
            addMe(count);
            //special dia 1 opp
            count = 1;
            for(int d = 0;d<4;d++) {
                if(b[d][d][d]==opp){
                    count++;
                }
                else if(b[d][d][d]==me) {
                    count = 0;
                    break;
                }
            }
            addOpp(count);
        }

        //special dia 2
        if(r==s){
            //special dia 2 me
            count = 1;
            for(int d = 0;d<4;d++){
                if(b[d][d][3-d]==me) {
                    count++;
                }
                else if(b[d][d][3-d]==opp) {
                    count = 0;
                    break;
                }
            }
            addMe(count);
            //special dia 2 opp
            count = 1;
            for(int d = 0;d<4;d++) {
                if(b[d][d][3-d]==opp) {
                    count++;
                }
                else if(b[d][d][3-d]==me) {
                    count = 0;
                    break;
                }
            }
            addOpp(count);
        }
        //special dia 3
        if(r==c) {
            //special dia 3 me
            count = 1;
            for(int d = 0;d<4;d++) {
                if(b[3-d][d][d]==me) {
                    count++;
                }
                if(b[3-d][d][d]==opp) {
                    count = 0;
                    break;
                }
            }
            addMe(count);
            //special dia 3 opp
            count = 1;
            for(int d = 0;d<4;d++){
                if(b[3-d][d][d]==opp) {
                    count++;
                }
                if(b[3-d][d][d]==me) {
                    count = 0;
                    break;
                }
            }
            addOpp(count);
        }

        //special dia 4
        if(c==s) {
            //special dia 4 me
            count = 1;
            for(int a = 0;a<4;a++) {
                if(b[3-a][a][3-a]==me) {
                    count++;
                }
                if(b[3-a][a][3-a]==opp) {
                    count = 0;
                    break;
                }
            }
            addMe(count);
            //special dia 4 opp
            count = 1;
            for(int a = 0;a<4;a++) {
                if(b[3-a][a][3-a]==opp) {
                    count++;
                }
                if(b[3-a][a][3-a]==me) {
                    count = 0;
                    break;
                }
            }
            addOpp(count);
        }
    }


    public void addMe(int c) {
        if(c>0) {
            mys[c-1] = mys[c-1]+1;
        }
    }


    public void addOpp(int c) {
        if(c>0){
            opps[c-1] = opps[c-1]+1;
        }
    }

}
