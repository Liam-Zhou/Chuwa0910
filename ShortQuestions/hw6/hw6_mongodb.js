// 1. Create test DB
use test

// 2. Create oms_company_address collection (method: createCollection() )
db.createCollection("oms_company_address")

// 3. Insert few random entries to oms_company_address collection (method: insert() )
// Insert multiple entries directly using insertMany()
db.oms_company_address.insertMany([
    {
        address_name: "address_1",
        send_status: 1,
        receive_status: 0,
        name: "A",
        phone: "111-111-1111",
        province: "province_0",
        city: "city_0",
        region: "region_0",
        detail_address: "detail_address_0"
    },
    {
        address_name: "address_2",
        send_status: 0,
        receive_status: 1,
        name: "B",
        phone: "222-222-2222",
        province: "province_2",
        city: "city_2",
        region: "region_2",
        detail_address: "detail_address_2"
    },,
    {
        address_name: "address_3",
        send_status: 0,
        receive_status: 1,
        name: "C",
        phone: "333-333-3333",
        province: "province_3",
        city: "city_3",
        region: "region_3",
        detail_address: "detail_address_3"
    },
]);


// 4. Read one entry from oms_company_address collection (method: find() )
db.oms_company_address.findOne({ address_name: "address_3" })

// 5. Read all entries from oms_company_address collection (method: find() )
db.oms_company_address.find()

// 6. Update one entry from oms_company_address collection (method: update() or save() )
db.oms_company_address.updateOne(
    { address_name: "address_3" },
    { $set: { phone: "444-444-4444", region: "region_4"}}
)

// 7. Remove one entry from oms_company_address collection (method: remove() )
db.oms_company_address.deleteOne({ address_name: "address_3" })
