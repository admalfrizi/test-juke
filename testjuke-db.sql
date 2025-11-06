DROP TABLE IF EXISTS "public"."employee";
-- Table Definition
CREATE TABLE "public"."employee" (
    "id" int4 NOT NULL,
    "created_at" timestamp,
    "email" varchar(255) NOT NULL,
    "name" varchar(255) NOT NULL,
    "position" varchar(255) NOT NULL,
    "salary" float8 NOT NULL,
    PRIMARY KEY ("id")
);

INSERT INTO "public"."employee" ("id", "created_at", "email", "name", "position", "salary") VALUES
(5, '2025-10-28 06:45:50.07014', 'mfhammad@gmail.com', 'Muhammad Fatih', 'Full Stack Engineer', 5000000),
(4, '2025-10-28 04:21:08.709627', 'aai23434@gmail.com', 'Adam Alfarizi Ismail', 'Software Engineer Intern', 3000000);
