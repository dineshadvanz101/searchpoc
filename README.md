Brand search POC developed by Advanz101.com
=======================================

Scope of work
-------------
We want to create a search option where user can search for brands. User can also use filter option for brand category (shoes, fashion for men, accessories, electronics, etc) in searching the brand.
User can also search just by clicking the Letters on the top section. This will show brands that start with the letter they have clicked.  
Data/brands will be coming from an [GET] API. Please create a dummy API for this.

Technologies used
-----------------
### Server side
- Java
- Spring framework
- MYSQL

### Client side
- HTML
- Vuejs
- Vuetify (Material Component Framework)
- CSS

Client (UI)
-----------
- **poc.html** - It is html rendered using vuetify component framework.
- **poc.component.ts** - It is the typescript developed using vuejs.

Server (REST)
-------------

- **restapi** - It is rest base APIs which provides Category, Brand and realted resources. RestAPI has two components called **search_resource** (jar) and **advanz_common_util** (jar).
- **search_resource** - All Rest APIs and business implementation are in search_resource (jar) module.
- **advanz_common_util** - Common functionalities like error handling and response format are managed by advanz_common_util module (jar).
