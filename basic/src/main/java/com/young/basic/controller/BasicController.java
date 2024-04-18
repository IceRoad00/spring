package com.young.basic.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.young.basic.service.BasicService;

import lombok.RequiredArgsConstructor;

// Controller 레이어:
// - 클라이언트와 서버간의 접점
// - 클라이언트의 요청을 받고 해당 요청에 대한 응답을 클라이언트에게 돌려주는 영역
// - 각 요청에 해당하는 URL 메서드를 작성하는 영역

// @RestController : JSON 형태의 ResponseBody를 반환하는 Controller임을 명시
// @RestController = @Controller + @ResponseBody
@RestController
// @RequestMapping(): HTTP 요청에 클래스와 메서드를 매핑하기 위한 어노테이션
// @RequestMapping(value="/main", method = {RequestMethod.GET})

// HTTP GET localhost:4000/main/**
@RequestMapping("/main")
// final로 선언된 필드 변수에 대해서 생성자를 자동으로 작성
@RequiredArgsConstructor
// @AllArgsConstructor
public class BasicController {
    
    // private BasicService service;
/*
    의존성 역전(DI) :
    - 해당 클래스에 필요한 의존성을 외부(클래스의 인스턴스를 생성하는 위치)에서 주입
    - 생성자를 통한 의존성 주입, setter 메서드를 통한 의존성 주입, 필드를 통한 의존성 주입

    - 생성자를 통한 의존성 주입을 Spring에서 권장 (의존성이 주입되지 않은 경우가 존재할 수 없기 때문)
    - Spring framework에서 의존성 주입은 제어의 역전(IOC)를 통해서 Spring framework가 진행
        (@component를 사용해서 Spring Bean으로 등록된 Class에 한해서)
*/

/* 
    @Autowired : 등록된 Spring Bean을 제어의 역전을 통해서 의존성을 주입하는 방법
    단, 생성자를 통한 의존성 주입에는 @Autowired를 생략해도 됨
*/
    // @Autowired
    // public BasicController(BasicService service) {
    //     this.service = service;
    // }

/*
    의존성 주입 시 클래스로 직접 참조변수를 만들지 않고 인터페이스로 간접적으로 만드는 이유:
    고수준의 모듈에서 저수준의 모듈을 직접 참조하지 않고 추상화를 통해 
        간접 참조함으로써 각 모듈 간의 결합도를 낮춤 -> 코드의 재사용성 향상, 유지보수성 향상
*/    
    private final BasicService service;
    
    // HTTP GET localhost:4000/main/
    @RequestMapping(value = "/", method = {RequestMethod.GET})
    public String getHello() {
        return service.getHello();
    }

    // ?HTTP GET Method : 클라이언트가 서버로부터 데이터를 받기를 원할 때 사용하는 메서드

    // @GetMapping() : RequestMapping 기능을 GET Method에 한정시킨 것 (가독성 + 안정성)
    @GetMapping("/apple")
    public String getApple() {
        return service.getApple();
    }

    // ?HTTP POST Method : 클라이언트가 서버에 데이터를 작성하기 원할 때 사용하는 메서드

    // @PostMapping() : RequestMapping 기능을 Post Method에 한정시킨 것 (가독성 + 안정성)
    @PostMapping("/apple")
    public String postApple() {
        return "Post Mapping으로 만든 메서드";
    }

    // ?HTTP PUT Method : 클라이언트가 서버에 있는 리소스 전체를 수정하고 싶을 때 사용하는 메서드

    // PutMapping() : RequestMapping 기능을 Put Method에 한정시킨 것 (가독성 + 안정성)
    @PutMapping("/apple")
    public String putApple() {
        return "Put Mapping으로 만든 메서드";
    }

    // ?HTTP PATCH Method : 클라이언트가 서버에 있는 리소스 일부를 수정하고 싶을 때 사용하는 메서드

    // PatchMapping() : RequestMapping 기능을 Patch Method에 한정시킨 것 (가독성 + 안정성)
    @PatchMapping("/apple")
    public String patchApple() {
        return "Path Mapping으로 만든 메서드";
    }

    // ?HTTP DELETE Method : 클라이언트가 서버에 있는 리소스를 삭제하고 싶을 때 사용하는 메서드
    // DeleteMapping() : RequestMapping 기능을 Delete Method에 한정시킨 것 (가독성 + 안정성)
    @DeleteMapping("/apple")
    public String deleteApple() {
        return "Delete Mapping으로 만든 메서드";
    }

    // Method + URL Pattern이 중복되면 런타임 중에 에러가 발생
    // @DeleteMapping("/apple")
    // public String deleteApple1() {
    //     return "Delete Mapping으로 만든 메서드";
    // }
}
