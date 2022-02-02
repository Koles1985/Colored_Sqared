package com.gamelabfedorovich.environment;

public class HorisontLine {
    private int column;
    private int[]colors;
    private int colorField;

    public HorisontLine(int column, int color){
        this.column = column;
        this.colorField = color;
        this.colors = createLine(color);
    }

    private int[] createLine(int color){
        int[]colors = new int[this.column];
        for(int i = 0; i < colors.length; i++){
            colors[i] = color;
        }
        return colors;
    }

    public void changeColorHorisontal(int step){
        for(int i = 0; i < colors.length; i++){
            //step = 1 цвета с правой стороны переходят на центральную
            if(step > 0) {
                colors[i]++;
                if(colors[i] > 5){
                    colors[i] = colors[i] - 6;
                }
            }
            //step = 0 цвета с левой стороны переходят на центральную
            if(step == 0){
                colors[i]--;
                if(colors[i] < 0){
                    colors[i] += 6;
                }
            }
        }
    }
}
