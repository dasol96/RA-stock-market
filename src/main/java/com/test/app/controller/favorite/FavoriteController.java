package com.test.app.controller.favorite;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.app.favorite.FavoriteService;
import com.test.app.favorite.FavoriteVO;

@Controller
public class FavoriteController {
	

	@Autowired
	private FavoriteService favoriteService;

	
	@RequestMapping(value="/infav.do")
	public String insert_fav(FavoriteVO vo,Model model) {
		//vo=favoritedao.selectOne(vo);
		//if(vo.getSpk()가 없는 spk라면) {
		favoriteService.insert_favorite(vo);
		//}
		
		return "main.do";
	}
	
	@RequestMapping(value="/delfav.do")
	public String delete_fav(FavoriteVO vo,HttpSession session) {
		System.out.println("로그 : FAVORITECONTROLLER : 즐겨찾기 삭제 fpk ="+vo.getFpk() +" vo " +vo);
		favoriteService.delete_favorite(vo);
		System.out.println("로그 : FAVORITECONTROLLER : 즐겨찾기 삭제 완료 mid ="+vo.getMid()+" vo " +vo);
		return "main.do";
	}
	
}
