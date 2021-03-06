--
-- PostgreSQL database dump
--

-- Dumped from database version 11.5
-- Dumped by pg_dump version 11.5

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: open_roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.open_roles (
    id uuid NOT NULL,
    party_id uuid,
    role_id integer,
    is_open boolean
);


ALTER TABLE public.open_roles OWNER TO postgres;

--
-- Name: parties; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.parties (
    id uuid NOT NULL,
    name character varying
);


ALTER TABLE public.parties OWNER TO postgres;

--
-- Name: party_members; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.party_members (
    id uuid NOT NULL,
    party_id uuid,
    user_id uuid,
    role_id integer,
    is_empty boolean
);


ALTER TABLE public.party_members OWNER TO postgres;

--
-- Name: position_skill_map; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.position_skill_map (
    id uuid NOT NULL,
    position_id uuid,
    skill_id bigint
);


ALTER TABLE public.position_skill_map OWNER TO postgres;

--
-- Name: positions; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.positions (
    id uuid NOT NULL,
    party_id uuid,
    user_id uuid,
    role_id integer,
    has_compensation boolean,
    has_equity boolean,
    is_open boolean
);


ALTER TABLE public.positions OWNER TO postgres;

--
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.roles (
    id integer NOT NULL,
    role_name character varying
);


ALTER TABLE public.roles OWNER TO postgres;

--
-- Name: skills; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.skills (
    id bigint NOT NULL,
    name character varying
);


ALTER TABLE public.skills OWNER TO postgres;

--
-- Name: skills_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.skills_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.skills_id_seq OWNER TO postgres;

--
-- Name: skills_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.skills_id_seq OWNED BY public.skills.id;


--
-- Name: user_skill_map; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_skill_map (
    id uuid NOT NULL,
    user_id uuid,
    skill_id uuid
);


ALTER TABLE public.user_skill_map OWNER TO postgres;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id uuid NOT NULL,
    username character varying,
    hash character varying,
    salt character varying
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: skills id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.skills ALTER COLUMN id SET DEFAULT nextval('public.skills_id_seq'::regclass);


--
-- Data for Name: open_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.open_roles (id, party_id, role_id, is_open) FROM stdin;
\.


--
-- Data for Name: parties; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.parties (id, name) FROM stdin;
adec4208-c756-4b9a-9bd4-c598d9ec682e	Zillow
6dc5e288-ea4b-4237-9bea-a52deaa1b0f6	Uber
\.


--
-- Data for Name: party_members; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.party_members (id, party_id, user_id, role_id, is_empty) FROM stdin;
ffa66be8-a073-4bc7-8ccf-302344aade56	6dc5e288-ea4b-4237-9bea-a52deaa1b0f6	\N	1	t
9c5600ce-4e55-4566-bca5-b615c2b949ef	6dc5e288-ea4b-4237-9bea-a52deaa1b0f6	\N	2	t
f3d1ac87-c3d6-4f30-a473-646005c9153f	6dc5e288-ea4b-4237-9bea-a52deaa1b0f6	\N	5	t
e76c63e1-e3fc-40e9-8f48-6705734c218e	6dc5e288-ea4b-4237-9bea-a52deaa1b0f6	\N	3	t
9b4d3482-755c-4e63-9dbe-9c07e70a3d0d	6dc5e288-ea4b-4237-9bea-a52deaa1b0f6	\N	1	t
\.


--
-- Data for Name: position_skill_map; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.position_skill_map (id, position_id, skill_id) FROM stdin;
\.


--
-- Data for Name: positions; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.positions (id, party_id, user_id, role_id, has_compensation, has_equity, is_open) FROM stdin;
0bd2a17f-afe4-4a85-aea7-2359d89a1a77	6dc5e288-ea4b-4237-9bea-a52deaa1b0f6	\N	0	t	f	t
1a7cafa2-0867-46e0-82a7-e1df607a0341	6dc5e288-ea4b-4237-9bea-a52deaa1b0f6	\N	1	t	f	t
\.


--
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.roles (id, role_name) FROM stdin;
1	Frontend Engineer
2	Backend Engineer
4	Data Scientist
5	Business Analyst
6	Finance Manager
7	Database Engineer
8	Owner
3	UX Designer
0	Backend Engineer
\.


--
-- Data for Name: skills; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.skills (id, name) FROM stdin;
1	Javascript
\.


--
-- Data for Name: user_skill_map; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_skill_map (id, user_id, skill_id) FROM stdin;
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, username, hash, salt) FROM stdin;
\.


--
-- Name: skills_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.skills_id_seq', 1, true);


--
-- Name: open_roles open_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.open_roles
    ADD CONSTRAINT open_roles_pkey PRIMARY KEY (id);


--
-- Name: parties parties_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.parties
    ADD CONSTRAINT parties_pkey PRIMARY KEY (id);


--
-- Name: party_members party_members_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.party_members
    ADD CONSTRAINT party_members_pkey PRIMARY KEY (id);


--
-- Name: position_skill_map position_skill_map_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.position_skill_map
    ADD CONSTRAINT position_skill_map_pkey PRIMARY KEY (id);


--
-- Name: positions positions_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.positions
    ADD CONSTRAINT positions_pkey PRIMARY KEY (id);


--
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- Name: skills skills_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.skills
    ADD CONSTRAINT skills_pkey PRIMARY KEY (id);


--
-- Name: user_skill_map user_skill_map_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_skill_map
    ADD CONSTRAINT user_skill_map_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

