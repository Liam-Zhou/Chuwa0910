use test

db

db.createCollection("oms_company_address")

db.posts.insertOne({
    id: 1,
    address_name: 'a',
    send_status: 1,
    receive_status: 1,
    name: 'a',
    phone: 'a',
    province: 'a',
    city: 'a',
    region: 'a',
    detail_address: 'a',
})

db.posts.insertOne({
    id: 2,
    address_name: 'b',
    send_status: 1,
    receive_status: 1,
    name: 'b',
    phone: 'b',
    province: 'b',
    city: 'b',
    region: 'b',
    detail_address: 'b',
})

db.posts.insertOne({
    id: 3,
    address_name: 'c',
    send_status: 1,
    receive_status: 1,
    name: 'c',
    phone: 'c',
    province: 'c',
    city: 'c',
    region: 'c',
    detail_address: 'c',
})

db.posts.insertOne({
    id: 4,
    address_name: 'd',
    send_status: 1,
    receive_status: 1,
    name: 'd',
    phone: 'd',
    province: 'd',
    city: 'd',
    region: 'd',
    detail_address: 'd',
})

db.posts.findOne();

db.posts.find();

db.posts.updateOne({id:1},{$set: {name: "uppdate one"}})

db.posts.deleteOne({id: 2})