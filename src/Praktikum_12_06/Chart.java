public class Chart {
    Bar[] bars;
    int index;

    Chart(int anzBalken) {
        if (anzBalken < 0) {
            throw new IllegalArgumentException("anzahlBalken >= 0");
        }
        bars = new Bar[anzBalken];
        index = 0;
    }

    public void up() {
        index = index < bars.length ? index + 1 : 0;
    }

    public void down() {
        index = index > 0 ? index - 1 : bars.length - 1;
    }

    public void setBar(Bar bar) {
        bars[index] = bar;
    }
    @Override
    public String toString() {
        String ret = "";
        for (int i = 0; i < bars.length; i++) {
            ret += i==index ? "* " :"";
            if (bars[i] != null) {
                ret += bars[i].toString() + "\n";
            }else{
                ret += "??? \n";
            }
        }
        
        return ret;
    }


}
