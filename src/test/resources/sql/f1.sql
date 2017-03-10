SELECT 

--the following is from orginal sql
--c.code, 
--a.code, 
--d.code, 
--cpt.description_c, 
--pe.name_b, 
--pe.first_name_b, 
--cp.*

--  the following is from dealer rep code
DISTINCT
pe.id client_id, 
cpt.description_c description, 
pe.name_b last_name, 
pe.first_name_b first_name, 
--a.code parent_portfolio_code, 
--d.code child_portfolio_code, 
--d.parent_port_id,
--cp.id, 
cp.reachability_b reachability, 
cp.add_line_1_b street, 
cp.country_b country, 
cp.region_b region, 
cp.city_b city, 
cp.post_code_b post_code, 
cp.comments_b comments, 
cp.tel_phonenumber_b phonenumber,
cp.web_address_b email_address 

--the following is from orginal sql
FROM 
OCS_MAIN..cdm_clientrelation cr, 
OCS_MAIN..cdm_participation p, 
OCS_MAIN..cdm_person pe, 
OCS_MAIN..cdm_participantrolemapping pm, 
OCS_MAIN..cdm_contactpointmapping cpm, 
OCS_MAIN..cdm_contact_point cp, 
OCS_MAIN..cdm_contactpointtype cpt, 
--OCS_MAIN..CUSTOM_cdm_contact_point ccp,  -- in this query, we don't have any result from this table
--OCS_MAIN..CUSTOM_cdm_person cpe,  -- in this query, we don't have any result from this table
TA_MAIN..portfolio a, 
TA_MAIN..ud_portfolio b, 
TA_MAIN..third_party c, 
TA_MAIN..portfolio d
WHERE a.id = b.ud_id
AND a.mgt_end_d is null
AND a.lock_type_id = 10006
AND a.type_id = 10009
AND b.ud_inv_type_e <> 11
AND c.id = b.ud_company_third_id
AND a.id = d.parent_port_id
AND d.mgt_end_d is null
AND cr.root_id_c = d.code
AND cr.id = p.clientrelation_id_c
AND p.close_date_d is null           -- Participation not closed
AND p.party_id_c = pe.id
AND pe.death_date_b is null       -- Client not dead
--AND p.party_id_c = cpe.id  -- in this query, we don't have any result from cpe table
AND p.id = pm.participation_id_c
AND pm.participant_role_id_i in (1, 19)   -- Owner and joint onwer
AND pe.id = cpm.party_id_c
AND cpm.contactpoint_id_c = cp.id
--AND cpm.contactpoint_id_c = ccp.id  -- in this query, we don't have any result from ccp table
AND cp.contactpointtype_id_i = cpt.id
AND cpt.description_c in ('Postal Address', 'Phone', 'Email Address', 'Mobile')

-- the following sql statement are on the class.
-- AND c.code = 'SPC'			-- SG company code
-- AND c.code in ('UFC', 'SPC')	-- Both APC and SG
-- AND (pe.name_b like 'Rairamo' AND pe.first_name_b like 'Diane')  -- Adjust this part to fit the search.
-- the following is from dealer rep code
-- ORDER BY client_id, description