import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class InstructionSetArchitecture {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {

		Scanner input = new Scanner(new File("input.txt"));
		PrintWriter pw=new PrintWriter(new File("output.hex"));

		pw.println("v2.0 raw");
		String binStr, hexStr, str, nzp,bin, imm_str, addr_str;
		int dest, src1, src2, op1, op2, addr, imm, decimal, length,limm;
		
		while (input.hasNext()) {
			String line = input.nextLine();
			String arr[] = new String[4];

			// splitting the line by space and commas
			int i = 0;
			for (String tag : line.split("[ ,]")) {
				arr[i] = tag;
				i++;
			}

			// do operations by the instructions
			switch (arr[0]) {
			
			case "ADD":
				// ADD's binary value is 0000 in our design
				binStr = "0010";

				// taking the decimal of the registers and converting to binary
				dest = Integer.parseInt(arr[1].substring(1));
				binStr = binStr.concat(Integer.toBinaryString(0x10 | dest).substring(1));

				src1 = Integer.parseInt(arr[2].substring(1));
				binStr = binStr.concat(Integer.toBinaryString(0x10 | src1).substring(1));

				src2 = Integer.parseInt(arr[3].substring(1));
				binStr = binStr.concat(Integer.toBinaryString(0x10 | src2).substring(1));

				// filling the last 2 bits with 0's
				binStr = binStr.concat("00");

				// converting from binary to hexadecimal
				decimal = Integer.parseInt(binStr, 2);
				hexStr = Integer.toString(decimal, 16);

				str = "";
				length = hexStr.length();
				// filling with 0's to complete 5 characters
				for (int j = 0; j < 5 - length; j++) {
					str = str.concat("0");
				}

				hexStr = str.concat(hexStr);

				System.out.println(binStr);
				pw.println(hexStr);
				break;

			case "ADDI":
				// ADDI's binary value is 0001 in our design
				binStr = "0011";

				// taking the decimal of the registers and immediate value, then converting to binary
				dest = Integer.parseInt(arr[1].substring(1));
				binStr = binStr.concat(Integer.toBinaryString(0x10 | dest).substring(1));

				src1 = Integer.parseInt(arr[2].substring(1));
				binStr = binStr.concat(Integer.toBinaryString(0x10 | src1).substring(1));

				imm = Integer.parseInt(arr[3]);				

				imm_str=Integer.toBinaryString(0x100 | imm).substring(1);

				//checking whether immediate value is negative or positive
				if(imm<0) {
					//if it is negative throwing away unnecessary 1's from head of number
					imm_str=imm_str.substring(25);
				}
				else {
					//if it is positive throwing away unnecessary 0's from head of number
					imm_str=imm_str.substring(2);
				}

				binStr = binStr.concat(imm_str);

				// converting from binary to hexadecimal
				decimal = Integer.parseInt(binStr, 2);
				hexStr = Integer.toString(decimal, 16);

				str = "";
				length = hexStr.length();

				//completing hexadecimal to 5 digit if it necessary
				for (int j = 0; j < 5 - length; j++) {
					str = str.concat("0");
				}

				hexStr = str.concat(hexStr);

				System.out.println(binStr);
				pw.println(hexStr);

				break;
			
			case "AND":
				// AND's binary value is 0010 in our design
				binStr = "0100";

				// taking the decimal of the registers and converting to binary
				dest = Integer.parseInt(arr[1].substring(1));
				binStr = binStr.concat(Integer.toBinaryString(0x10 | dest).substring(1));

				src1 = Integer.parseInt(arr[2].substring(1));
				binStr = binStr.concat(Integer.toBinaryString(0x10 | src1).substring(1));

				src2 = Integer.parseInt(arr[3].substring(1));
				binStr = binStr.concat(Integer.toBinaryString(0x10 | src2).substring(1));

				binStr = binStr.concat("00");

				// converting from binary to hexadecimal
				decimal = Integer.parseInt(binStr, 2);
				hexStr = Integer.toString(decimal, 16);
				str = "";
				length = hexStr.length();
				for (int j = 0; j < 5 - length; j++) {
					str = str.concat("0");
				}

				//completing hexadecimal to 5 digit if it necessary
				hexStr = str.concat(hexStr);

				System.out.println(binStr);
				pw.println(hexStr);
				break;
			
			case "ANDI":
				// ANDI's binary value is 0011 in our design
				binStr = "0101";

				// taking the decimal of the registers and immediate value, then converting to binary
				dest = Integer.parseInt(arr[1].substring(1));
				binStr = binStr.concat(Integer.toBinaryString(0x10 | dest).substring(1));

				src1 = Integer.parseInt(arr[2].substring(1));
				binStr = binStr.concat(Integer.toBinaryString(0x10 | src1).substring(1));

				imm = Integer.parseInt(arr[3]);
				imm_str=Integer.toBinaryString(0x100 | imm).substring(1);

				//checking whether immediate value is negative or positive
				if(imm<0) {
					//if it is negative throwing away unnecessary 1's from head of number
					imm_str=imm_str.substring(25);
				}
				else {
					//if it is positive throwing away unnecessary 0's from head of number
					imm_str=imm_str.substring(2);
				}

				binStr = binStr.concat(imm_str);

				// converting from binary to hexadecimal
				decimal = Integer.parseInt(binStr, 2);
				hexStr = Integer.toString(decimal, 16);
				str = "";
				length = hexStr.length();

				//completing hexadecimal to 5 digit if it necessary
				for (int j = 0; j < 5 - length; j++) {
					str = str.concat("0");
				}

				hexStr = str.concat(hexStr);

				System.out.println(binStr);
				pw.println(hexStr);

				break;
			
			case "OR":
				// OR's binary value is 0100 in our design
				binStr = "0110";

				// taking the decimal of the registers and converting to binary
				dest = Integer.parseInt(arr[1].substring(1));
				binStr = binStr.concat(Integer.toBinaryString(0x10 | dest).substring(1));

				src1 = Integer.parseInt(arr[2].substring(1));
				binStr = binStr.concat(Integer.toBinaryString(0x10 | src1).substring(1));

				src2 = Integer.parseInt(arr[3].substring(1));
				binStr = binStr.concat(Integer.toBinaryString(0x10 | src2).substring(1));

				binStr = binStr.concat("00");

				// converting from binary to hexadecimal
				decimal = Integer.parseInt(binStr, 2);
				hexStr = Integer.toString(decimal, 16);
				str = "";
				length = hexStr.length();

				//completing hexadecimal to 5 digit if it necessary
				for (int j = 0; j < 5 - length; j++) {
					str = str.concat("0");
				}

				hexStr = str.concat(hexStr);

				System.out.println(binStr);
				pw.println(hexStr);
				break;
			
			case "ORI":
				// ORI's binary value is 0101 in our design
				binStr = "0111";

				// taking the decimal of the registers and immediate value, then converting to binary
				dest = Integer.parseInt(arr[1].substring(1));
				binStr = binStr.concat(Integer.toBinaryString(0x10 | dest).substring(1));

				src1 = Integer.parseInt(arr[2].substring(1));
				binStr = binStr.concat(Integer.toBinaryString(0x10 | src1).substring(1));

				imm = Integer.parseInt(arr[3]);
				imm_str=Integer.toBinaryString(0x100 | imm).substring(1);

				//checking whether immediate value is negative or positive
				if(imm<0) {
					//if it is negative throwing away unnecessary 1's from head of number
					imm_str=imm_str.substring(25);
				}
				else {
					//if it is positive throwing away unnecessary 0's from head of number
					imm_str=imm_str.substring(2);
				}

				binStr = binStr.concat(imm_str);

				// converting from binary to hexadecimal
				decimal = Integer.parseInt(binStr, 2);
				hexStr = Integer.toString(decimal, 16);

				str = "";
				length = hexStr.length();

				//completing hexadecimal to 5 digit if it necessary
				for (int j = 0; j < 5 - length; j++) {
					str = str.concat("0");
				}

				hexStr = str.concat(hexStr);

				System.out.println(binStr);
				pw.println(hexStr);
				break;
			
			case "XOR":
				// XOR's binary value is 0110 in our design
				binStr = "1000";

				//Taking register values and converting them to the binary string
				dest = Integer.parseInt(arr[1].substring(1));
				binStr = binStr.concat(Integer.toBinaryString(0x10 | dest).substring(1));

				src1 = Integer.parseInt(arr[2].substring(1));
				binStr = binStr.concat(Integer.toBinaryString(0x10 | src1).substring(1));

				src2 = Integer.parseInt(arr[3].substring(1));
				binStr = binStr.concat(Integer.toBinaryString(0x10 | src2).substring(1));

				//For unused 2 bits
				binStr = binStr.concat("00");

				//Converting binary string to hexadecimal number step by step
				decimal = Integer.parseInt(binStr, 2);
				hexStr = Integer.toString(decimal, 16);
				
				//completing hexadecimal to 5 digit if it necessary
				str = "";
				length = hexStr.length();
				for (int j = 0; j < 5 - length; j++) {
					str = str.concat("0");
				}

				hexStr = str.concat(hexStr);

				System.out.println(binStr);
				pw.println(hexStr);

				break;
			
			case "XORI":
				// XOR's binary value is 0111 in our design
				binStr = "1001";

				//Taking register and immediate values and converting them to the binary string
				dest = Integer.parseInt(arr[1].substring(1));
				binStr = binStr.concat(Integer.toBinaryString(0x10 | dest).substring(1));

				src1 = Integer.parseInt(arr[2].substring(1));
				binStr = binStr.concat(Integer.toBinaryString(0x10 | src1).substring(1));

				imm = Integer.parseInt(arr[3]);
				bin = Integer.toBinaryString(imm);

				//if number is negative, get rid of unnecessary 1s and if it is positive add 0s to complete 18bits
				limm=bin.length();
				if(imm>=0) { 
					for(i=0;i<6-limm;i++)
						binStr=binStr.concat("0");
					binStr=binStr.concat(bin);
				}
				else
					binStr=binStr.concat(bin.substring(limm-6));

				//Converting binary string to hexadecimal number step by step
				decimal = Integer.parseInt(binStr, 2);
				hexStr = Integer.toString(decimal, 16);
				
				//completing hexadecimal to 5 digit if it necessary
				str = "";
				length = hexStr.length();
				for (int j = 0; j < 5 - length; j++) {
					str = str.concat("0");
				}

				hexStr = str.concat(hexStr);

				System.out.println(binStr);
				pw.println(hexStr);

				break;
			
			case "JUMP":
				// JUMP's binary value is 1000 in our design
				binStr = "1010";

				//Taking address value and converting it to the binary string
				addr = Integer.parseInt(arr[1]);
				bin = Integer.toBinaryString(addr);

				//if address is negative, get rid of unnecessary 1s and if it is positive add 0s to complete 18bits
				limm=bin.length();
				if(addr>=0) { 
					for(i=0;i<14-limm;i++)
						binStr=binStr.concat("0");
					binStr=binStr.concat(bin);
				}
				else
					binStr=binStr.concat(bin.substring(limm-14));

				//Converting binary string to hexadecimal number step by step
				decimal = Integer.parseInt(binStr, 2);
				hexStr = Integer.toString(decimal, 16);
				
				//completing hexadecimal to 5 digit if it necessary
				str = "";
				length = hexStr.length();
				for (int j = 0; j < 5 - length; j++) {
					str = str.concat("0");
				}

				hexStr = str.concat(hexStr);

				System.out.println(binStr);
				pw.println(hexStr);

				break;
			
			case "LD":
				// LD's binary value is 1001 in our design
				binStr = "1011";

				//Taking register and address values and converting them to the binary string
				dest = Integer.parseInt(arr[1].substring(1));
				binStr = binStr.concat(Integer.toBinaryString(0x10 | dest).substring(1));

				addr = Integer.parseInt(arr[2]);
				bin = Integer.toBinaryString(addr);

				//if address is negative, get rid of unnecessary 1s and if it is positive add 0s to complete 18bits
				limm=bin.length();
				if(addr>=0) { 
					for(i=0;i<10-limm;i++)
						binStr=binStr.concat("0");
					binStr=binStr.concat(bin);
				}
				else
					binStr=binStr.concat(bin.substring(limm-10));

				//Converting binary string to hexadecimal number step by step
				decimal = Integer.parseInt(binStr, 2);
				hexStr = Integer.toString(decimal, 16);
				
				//completing hexadecimal to 5 digit if it necessary
				str = "";
				length = hexStr.length();
				for (int j = 0; j < 5 - length; j++) {
					str = str.concat("0");
				}

				hexStr = str.concat(hexStr);

				System.out.println(binStr);
				pw.println(hexStr);
				break;
			
			case "ST":
				// XOR's binary value is 1010 in our design
				binStr = "1101";

				//Taking register and address values and converting them to the binary string
				src1 = Integer.parseInt(arr[1].substring(1));
				binStr = binStr.concat(Integer.toBinaryString(0x10 | src1).substring(1));

				addr = Integer.parseInt(arr[2]);
				bin = Integer.toBinaryString(addr);

				//if address is negative, get rid of unnecessary 1s and if it is positive add 0s to complete 18bits
				limm=bin.length();
				if(addr>=0) { 
					for(i=0;i<10-limm;i++)
						binStr=binStr.concat("0");
					binStr=binStr.concat(bin);
				}
				else
					binStr=binStr.concat(bin.substring(limm-10));

				//Converting binary string to hexadecimal number step by step
				decimal = Integer.parseInt(binStr, 2);
				hexStr = Integer.toString(decimal, 16);
				
				//completing hexadecimal to 5 digit if it necessary
				str = "";
				length = hexStr.length();
				for (int j = 0; j < 5 - length; j++) {
					str = str.concat("0");
				}

				hexStr = str.concat(hexStr);

				System.out.println(binStr);
				pw.println(hexStr);
				break;
			
			case "BEQ":
				// BEQ's binary value is 1011 in our design
				binStr = "1110";

				op1 = Integer.parseInt(arr[1].substring(1));
				binStr = binStr.concat(Integer.toBinaryString(0x10 | op1).substring(1));

				op2 = Integer.parseInt(arr[2].substring(1));
				binStr = binStr.concat(Integer.toBinaryString(0x10 | op2).substring(1));

				// only negative value will be 1 in BLT
				nzp = "010";
				binStr += nzp;

				addr = Integer.parseInt(arr[3]);
				addr_str = Integer.toBinaryString(0x10 | addr).substring(1);

				// checking whether immediate value is negative or positive
				if (addr < 0) {
					// if it is negative throwing away unnecessary 1's from head of number
					addr_str = addr_str.substring(28);
				} else {
					// if it is positive throwing away unnecessary 0's from head of number
					addr_str = addr_str.substring(1);
				}

				binStr = binStr.concat(addr_str);

				// converting from binary to hexadecimal
				decimal = Integer.parseInt(binStr, 2);
				hexStr = Integer.toString(decimal, 16);

				System.out.println(binStr);
				pw.println(hexStr);
				break;

			case "BLT":
				// BLT's binary value is 1100 in our design
				binStr = "1110";

				op1 = Integer.parseInt(arr[1].substring(1));
				binStr = binStr.concat(Integer.toBinaryString(0x10 | op1).substring(1));

				op2 = Integer.parseInt(arr[2].substring(1));
				binStr = binStr.concat(Integer.toBinaryString(0x10 | op2).substring(1));

				// only negative value will be 1 in BLT
				nzp = "100";
				binStr += nzp;

				addr = Integer.parseInt(arr[3]);
				// filling with 0's to complete 3 characters
				if (addr < 2) {
					binStr += "00";
				} else if (addr < 4) {
					binStr += "0";
				}
				binStr = binStr.concat(Integer.toBinaryString(addr));

				// converting from binary to hexadecimal
				decimal = Integer.parseInt(binStr, 2);
				hexStr = Integer.toString(decimal, 16);

				System.out.println(binStr);
				pw.println(hexStr);
				break;
			
			case "BLE":
				// BLE's binary value is 1101 in our design
				binStr = "1110";

				op1 = Integer.parseInt(arr[1].substring(1));
				binStr = binStr.concat(Integer.toBinaryString(0x10 | op1).substring(1));

				op2 = Integer.parseInt(arr[2].substring(1));
				binStr = binStr.concat(Integer.toBinaryString(0x10 | op2).substring(1));

				// only negative value will be 1 in BLT
				nzp = "110";
				binStr += nzp;

				addr = Integer.parseInt(arr[3]);
				addr_str = Integer.toBinaryString(0x10 | addr).substring(1);

				// checking whether immediate value is negative or positive
				if (addr < 0) {
					// if it is negative throwing away unnecessary 1's from head of number
					addr_str = addr_str.substring(28);
				} else {
					// if it is positive throwing away unnecessary 0's from head of number
					addr_str = addr_str.substring(1);
				}

				binStr = binStr.concat(addr_str);

				// converting from binary to hexadecimal
				decimal = Integer.parseInt(binStr, 2);
				hexStr = Integer.toString(decimal, 16);

				System.out.println(binStr);
				pw.println(hexStr);
				break;
			
			case "BGT":
				// BGT's binary value is 1110 in our design
				binStr = "1110";

				op1 = Integer.parseInt(arr[1].substring(1));
				binStr = binStr.concat(Integer.toBinaryString(0x10 | op1).substring(1));

				op2 = Integer.parseInt(arr[2].substring(1));
				binStr = binStr.concat(Integer.toBinaryString(0x10 | op2).substring(1));

				// only negative value will be 1 in BLT
				nzp = "001";
				binStr += nzp;

				addr = Integer.parseInt(arr[3]);
				addr_str = Integer.toBinaryString(0x10 | addr).substring(1);

				// checking whether immediate value is negative or positive
				if (addr < 0) {
					// if it is negative throwing away unnecessary 1's from head of number
					addr_str = addr_str.substring(28);
				} else {
					// if it is positive throwing away unnecessary 0's from head of number
					addr_str = addr_str.substring(1);
				}

				binStr = binStr.concat(addr_str);

				// converting from binary to hexadecimal
				decimal = Integer.parseInt(binStr, 2);
				hexStr = Integer.toString(decimal, 16);

				System.out.println(binStr);
				pw.println(hexStr);
				break;
			
			case "BGE":
				// BGE's binary value is 1111 in our design
				binStr = "1110";

				op1 = Integer.parseInt(arr[1].substring(1));
				binStr = binStr.concat(Integer.toBinaryString(0x10 | op1).substring(1));

				op2 = Integer.parseInt(arr[2].substring(1));
				binStr = binStr.concat(Integer.toBinaryString(0x10 | op2).substring(1));

				// only negative value will be 1 in BLT
				nzp = "011";
				binStr += nzp;

				addr = Integer.parseInt(arr[3]);
				addr_str = Integer.toBinaryString(0x10 | addr).substring(1);

				// checking whether immediate value is negative or positive
				if (addr < 0) {
					// if it is negative throwing away unnecessary 1's from head of number
					addr_str = addr_str.substring(28);
				} else {
					// if it is positive throwing away unnecessary 0's from head of number
					addr_str = addr_str.substring(1);
				}

				binStr = binStr.concat(addr_str);

				// converting from binary to hexadecimal
				decimal = Integer.parseInt(binStr, 2);
				hexStr = Integer.toString(decimal, 16);

				System.out.println(binStr);
				pw.println(hexStr);
				break;
			}
			pw.flush();
		}
	}

}
