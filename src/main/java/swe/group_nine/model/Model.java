package swe.group_nine.model;

public interface Model {

    void setRows(int rows);

    int getRows();

    void setCols(int cols);

    int getCols();

    int getWIDTH();

    void setHEIGHT(int HEIGHT);

    int getHEIGHT();

    int getSQUARE_SIZE();

    void setDifficulty(Difficulty difficulty);

    Difficulty getDifficulty();
}
