# Schedule API
| 매핑           | 기능   | 파라미터                          | 요청                                                                                                  | 응답                                                                                                  | url         |
|----------------|--------|-----------------------------------|---------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------|--------------|
| PostMapping     | 추가   | @RequestBody                      | {<br/>"title" : "제목",<br/>"content" : "내용"<br/>}                                                   | 동일 형식                                                                                              | /schedule    |
| GetMapping      | 조회   | 없음                               |                                                                                                         | {<br/>"title" : "제목",<br/>"content" : "내용"<br/>}                                                   | /schedule    |
| GetMapping      | 조회   | @PathVariable                     |                                                                                                         | {<br/>"title" : "제목",<br/>"content" : "내용"<br/>}                                                   | /schedule/id |
| PutMapping      | 수정   | @PathVariable <br/>@RequestBody   | {<br/>"title" : "수정된 제목",<br/>"content" : "수정된 내용"<br/>}                                     | 동일 형식                                                                                              | /schedule/id |
| DeleteMapping   | 삭제   | @PathVariable                     |                                                                                                         | 동일 형식                                                                                              | /schedule/id |

# User API
| 매핑           | 기능   | 파라미터                          | 요청                                                                                                                  | 응답                                                                                                                  | url      |
|----------------|--------|-----------------------------------|-------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------|-----------|
| PostMapping     | 추가   | @RequestBody                      | {<br/>"name" : "이름",<br/>"email" : "email@example.com",<br/>"pw" : "textpw123"<br/>}                                 | 동일 형식                                                                                                              | /user     |
| GetMapping      | 조회   | 없음                               |                                                                                                                         | {<br/>"name" : "이름",<br/>"email" : "email@example.com",<br/>"pw" : "textpw123"<br/>}                                 | /user     |
| GetMapping      | 조회   | @PathVariable                     |                                                                                                                         | {<br/>"name" : "이름",<br/>"email" : "email@example.com",<br/>"pw" : "textpw123"<br/>}                                 | /user/id  |
| PutMapping      | 수정   | @PathVariable <br/>@RequestBody   | {<br/>"name" : "수정된 이름",<br/>"email" : "newemail@example.com",<br/>"pw" : "newtextpw123"<br/>}                   | 동일 형식                                                                                                              | /user/id  |
| DeleteMapping   | 삭제   | @PathVariable                     |                                                                                                                         | 동일 형식                                                                                                              | /user/id  |

# LoginController
| 매핑 | 기능   | 파라미터         | 요청                                                         | 응답 | url |
| -- |------|--------------|------------------------------------------------------------| --- | ---|
|PostMapping | 회원가입 | @RequestParam | {<br/>"email" : "email@example.com",<br/>"pw" : "pw123"<br/>} | 동일 형식 | /registry/signup |
| PostMapping | 로그인  | @RequestParam  | {<br/>"email" : "email@example.com",<br/>"pw" : "pw123"<br/>} | 동일 형식 |/registry/login |


# Comment API
| 매핑 | 기능 | 파라미터         | 요청                                            | 응답                                   | url         |
| -- | --- |--------------|-----------------------------------------------|--------------------------------------|-------------|
|PostMapping | 추가 | @RequestBody | {<br/>"commentContents" : "댓글"<br/>}<br/>     | 동일 형식                                | /comment    |
| GetMapping | 조회 | @PathVariable |                                               | {<br/>"commentContents" : "댓글"<br/>}<br/><br/> | /comment/id |
| PutMapping | 수정 | @PathVariable <br/>@RequestBody | {<br/>"commentContents" : "수정된 댓글"<br/>}<br/><br/> | 동일 형식                                | /comment/id |
| DeleteMapping | 삭제 | @PathVariable |                                               | | /comment/id |
