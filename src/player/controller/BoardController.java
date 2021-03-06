package player.controller;

import player.models.Board;
import player.models.Square;
import player.models.Word;
import player.view.game.BoardPanel;
import player.view.game.SquarePanel;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class BoardController extends MouseAdapter {
    BoardPanel boardPanel;
    Board board;
    //ArrayList<SquarePanel> squarePanels;
    ArrayList<Square> squares;
    SquarePanel squarePanel;
    Square square;


    /**
     * Constructor
     * @param  sp square panel
     * @param  sq square model
     * @param  bp board panel
     * @param  b  board model
     */
    public BoardController(SquarePanel sp, Square sq, BoardPanel bp, Board b) {
		boardPanel = bp;
		squarePanel = sp;
		square = sq;
		board = b;
		board.renewTempWord();
    }

	@Override
    public void mousePressed(MouseEvent me) {
		if (squarePanel.getBackground() == Color.WHITE){
			if (board.addSquareToTempWord(square)) {
				squarePanel.toggleJustColor();
				squarePanel.toggleJustSelected();
			}
			System.out.print("word made: ");
			System.out.print(board.getSquareList().indexOf(square));
			System.out.print(" " + board.getTempWord().getWordString());
			System.out.print("\n");
			System.out.println("state: " + square.isEnabled());
		}
    }
}
