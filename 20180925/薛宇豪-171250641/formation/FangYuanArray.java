package formation;

import creature.Creature;
import field.BattleField;

public class FangYuanArray extends Formation {
    public FangYuanArray(int row, int column) {
        super(row,column);
    }
    public BattleField embattle(Creature[] creatures){
        Creature[] newRoles=new Creature[8];
        if(creatures.length<8){
            for(int i=0;i<creatures.length;i++){
                newRoles[i]=creatures[i];
            }
            for(int i=creatures.length;i<8;i++){
                newRoles[i]=creatures[creatures.length-1];
            }
        }else{
            for(int i=0;i<8;i++){
                newRoles[i]=creatures[i];
            }
        }
        if(row<5 || column<5){
            System.out.println("所排人数超过了当前阵列的范围！");
            return null;
        }else {
            int vacancyRow = (row - 5) / 2;
            int vacancyColumn = (column - 5) / 2;
            field.battlefield[vacancyRow][vacancyColumn+2].setCreature(newRoles[3]);
            field.battlefield[vacancyRow+1][vacancyColumn+1].setCreature(newRoles[1]);
            field.battlefield[vacancyRow+1][vacancyColumn+3].setCreature(newRoles[5]);
            field.battlefield[vacancyRow+2][vacancyColumn].setCreature(newRoles[0]);
            field.battlefield[vacancyRow+2][vacancyColumn+4].setCreature(newRoles[7]);
            field.battlefield[vacancyRow+3][vacancyColumn+1].setCreature(newRoles[2]);
            field.battlefield[vacancyRow+3][vacancyColumn+3].setCreature(newRoles[6]);
            field.battlefield[vacancyRow+4][vacancyColumn+2].setCreature(newRoles[4]);
        }
        return field;
    }
}
