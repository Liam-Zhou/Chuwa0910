# HW8 - Ke Chen

## 1. In your redbook application, write the code for RUD APIs
1.  https://github.com/TAIsRich/springboot-redbook.git
    1.  Branch: 02_post_RUD
2.  you need to call the new APIs in your postman.
3.  You need to type it line by line and try your best to understand it. DO NOT COPY PASTE

see files in coding : springboot-redbook

## 01_post_C
 1. create project by website - spring initializr
 2. Define a HTTP POST API
    create class PostController in package controller
 3. create SpringBoot Project Structure : packages of controller, dao, entity, exception, payload, service

4. create Database & Configure datasource by using IDEA
https://blog.csdn.net/qq_35500719/article/details/126068630

    create class Post(table: Posts and column details)
5. create interface PostRepository extends JpaRepository<Post, Long> in package dao

    提供对table级别的CRUD
    Post is the entity class
    Long is the ID data type of Post
6. create class PostDto in package payload

    因为业务逻辑需要在不同的object中转换（创建table：post的object）
    DTO(Data Transfer Object) is the only java class
7. create interface PostService and class PostServiceImpl implements PostService in package service

    核心业务逻辑层
    实现createPost和getAllPost()方法
8. create class PostController in package controller

    define APIs: Post - C, GET - R, UPDATE - U, Delete - D, Exception

## 02_post_RUD
create class PostGraphQLController in package controller

## 03_post_pageable
create class PostResponse in package payload
create class AppConstantsa ina new package util

## 04_comment
create class Comment(table: comments and column details)
create interface CommentRepository extends JpaRepository<Comment, Long>
create class CommentDto in package payload
create interface CommentService and class CommentServiceImpl implements CommentService
create class CommentController in package controller

## 2. GraphQL implementation: add  mutation  for create POST 
create class PostGraphQLController in package controller


## 3. Add new Entity/Table/Type  Authors
1.  Create  CRUD  REST APIs for  Author
2.  Create  Query  &  Mutation  GraphQL APIs for  Author

answers: follow the steps in Q1

create class Author(table: author and column details)
create interface AuthorRepository extends JpaRepository<Author, Long>
create class AuthorDto in package payload
create interface AuthorService and class AuthorServiceImpl implements AuthorService
create class AuthorController in package controller

see files in coding : springboot-redbook





