package com.lld.tictactoe;

import domain.TicTacToe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TictactoeApplication {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter board size (n): ");
		int n = scanner.nextInt();

		TicTacToe game = new TicTacToe(n);

		int player  = 1;
		while(game.getWinner() == 0){
			System.out.println("Player " + player +" s turn.Enter row and column: ");
			int row = scanner.nextInt();
			int col = scanner.nextInt();

			try{
				game.move(player, row, col);
				game.printBoard();
				player = player == 1 ? 2 : 1;
			}catch (IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}

		System.out.println("Player " + game.getWinner() + " wins!");
		scanner.close();

	}

}
