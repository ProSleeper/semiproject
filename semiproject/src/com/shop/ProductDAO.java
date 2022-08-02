package com.shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDAO {
	
	private Connection conn;
	
	
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql;
	
	public ProductDAO(Connection conn) {
		this.conn = conn;
	}
	
	
	
	//num�� �ִ밪 ������ ��ǰ��ȣ �����
	public int getMaxNum() {
		
		int maxNum = 0;
		
		try {
			
			sql = "select nvl(max(num),0) from product";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				maxNum = rs.getInt(1);//�÷��� �ϳ��������� �Ļ��÷��̱⋚���� �̸��� ��������
				
			}
			
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return maxNum;
	}
		
	//�Է� --��ǰ�߰�
	
	public int insertProduct(ProductDTO dto) {
		
		int result = 0;
		
		try {
			
			sql = "insert into product (num,name,price,category,brand,pro_size,";
			sql+= "tag,saveFileName values (?.?.?.?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getNum());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getPrice());
			pstmt.setInt(4, dto.getCategory());
			pstmt.setInt(5, dto.getBrand());
			pstmt.setInt(6, dto.getPro_size());
			pstmt.setInt(7, dto.getTag());
			pstmt.setString(8, dto.getSaveFileName());
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
			 
		}
		
		return result;
		
	}
	
	//���
	
	
	
	
	//����
	
	
	//����
	
}
