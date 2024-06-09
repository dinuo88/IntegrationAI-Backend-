CREATE TABLE user
(
    user_id  INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE model
(
    model_id      INT PRIMARY KEY AUTO_INCREMENT,
    model_name_cn VARCHAR(255) NOT NULL,
    model_name_en VARCHAR(255) NOT NULL
);


CREATE TABLE session
(
    session_id   Varchar(9) PRIMARY KEY ,
    user_id      INT          NOT NULL,
    system_param TEXT,
    FOREIGN KEY (user_id) REFERENCES user (user_id)
);

CREATE TABLE chat_message
(
    message_id INT PRIMARY KEY AUTO_INCREMENT,
    session_id Varchar(9)         NOT NULL,
    role       VARCHAR(50) NOT NULL,
    content    TEXT        NOT NULL,
    FOREIGN KEY (session_id) REFERENCES session (session_id)
);

insert into model
values (1, '智普轻言', 'ChatGlm'),
       (2, '文心一言', 'ErnieBot'),
       (3, '通义千问', 'QianWen');

insert into user
values (1,'admin','admin');

insert into chat_message
values (1,'8HJ75olF', 'user', '你好，我叫张三，应聘Web前端开发工程师'),
       (2,'8HJ75olF', 'assistant', '好的，张三，非常感谢你来到我们公司面试。首先请你简要介绍一下你的技能和工作经验，以便我们更好地了解你的背景和能力。');

