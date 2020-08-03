package swe.group_nine.model;

public interface Model {

    void setRows(int rows);

    int getRows();

    void setCols(int cols);

    int getCols();

    void setWIDTH(int WIDTH);

    int getWIDTH();

    void setHEIGHT(int HEIGHT);

    int getHEIGHT();

    void setSQUARE_SIZE(int SQUARE_SIZE);

    int getSQUARE_SIZE();

    void setDifficulty(Difficulty difficulty);

    Difficulty getDifficulty();
}
